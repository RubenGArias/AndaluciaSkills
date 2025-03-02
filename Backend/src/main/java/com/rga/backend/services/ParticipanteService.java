package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.rga.backend.models.Participante;
import com.rga.backend.requests.ParticipanteRequest;

public interface ParticipanteService {
    List<Participante> findAll();
    Optional<Participante> findById(Long id);
    Participante save(Participante participante);
    void deleteById(Long id);
    ResponseEntity<?> crear(ParticipanteRequest request);
    List<Participante> findByEspecialidadId(Long idEspecialidad);
}
