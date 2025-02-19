package com.rga.backend.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rga.backend.models.Especialidad;
import com.rga.backend.models.User;
import com.rga.backend.repositories.EspecialidadRepository;
import com.rga.backend.repositories.UserRepository;
import com.rga.backend.requests.LoginRequest;
import com.rga.backend.requests.RegisterRequest;
import com.rga.backend.security.JwtTokenProvider;
import com.rga.backend.services.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();    
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public ResponseEntity<?> register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya está en uso.");
        }

        Especialidad especialidad = especialidadRepository.findById(request.getIdEspecialidad())
            .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        User user = User.builder()
            .role(request.getRole())
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword())) // Encripta la contraseña
            .dni(request.getDni())
            .nombre(request.getNombre())
            .apellidos(request.getApellidos())
            .especialidad(especialidad)
            .build();

        userRepository.save(user);
        return ResponseEntity.ok("Usuario creado correctamente");
    }

    @Transactional
    public ResponseEntity<?> login(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByUsername(request.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                // Generar token usando la instancia de jwtTokenProvider
                UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), new ArrayList<>()
                );
                String token = jwtTokenProvider.generateToken(userDetails); // Ahora sí funciona

                // Crear un JSON con el mensaje y el token
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Login exitoso");
                response.put("username", user.getUsername());
                response.put("token", token);

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body(Map.of("error", "Contraseña incorrecta"));
            }
        } else {
            return ResponseEntity.badRequest().body(Map.of("error", "Usuario no encontrado"));
        }
    }

    

}
