package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import com.rga.backend.models.Participante;

public interface ParticipanteService {
    List<Participante> findAll();
    Optional<Participante> findById(Long id);
    Participante save(Participante participante);
    void deleteById(Long id);

}
