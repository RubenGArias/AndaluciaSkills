package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.rga.backend.models.Especialidad;
import com.rga.backend.models.User;
import com.rga.backend.requests.LoginRequest;
import com.rga.backend.requests.RegisterRequest;

public interface UserService {
    List <User> findAll();
    Optional <User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
    ResponseEntity<?> register(RegisterRequest request);
    ResponseEntity<?> login(LoginRequest request);
    List <User> findExpertos();
    Especialidad findEspecialidadByUsername(String username);
    
}
