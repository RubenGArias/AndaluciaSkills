package com.rga.backend.services.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rga.backend.models.Participante;
import com.rga.backend.repositories.EspecialidadRepository;
import com.rga.backend.repositories.ParticipanteRepository;
import com.rga.backend.requests.ParticipanteRequest;
import com.rga.backend.services.ParticipanteService;
import com.rga.backend.models.Especialidad;



@Service
public class ParticipanteServiceImpl implements ParticipanteService{
    @Autowired
    private ParticipanteRepository repository;
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public List<Participante> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Participante> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Participante save(Participante participante) {
        return repository.save(participante);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ResponseEntity<?> crear(ParticipanteRequest request) {
        System.out.println("Datos recibidos:");
        System.out.println("Nombre: " + request.getNombre());
        System.out.println("Apellidos: " + request.getApellidos());
        System.out.println("Centro: " + request.getCentro());
        System.out.println("ID Especialidad: " + request.getIdEspecialidad());

        Especialidad especialidad = especialidadRepository.findById(request.getIdEspecialidad())
        .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        Participante p = Participante.builder()
        .nombre(request.getNombre())
        .apellidos(request.getApellidos())
        .centro(request.getCentro())
        .especialidad(especialidad)
        .build();

        repository.save(p);
        return ResponseEntity.ok(Map.of("message", "Participante añadido"));
    }



    @Override
    public List<Participante> findByEspecialidadId(Long idEspecialidad) {
        return repository.findByEspecialidadId(idEspecialidad);

    }

    

}
