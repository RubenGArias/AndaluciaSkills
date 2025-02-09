package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import com.rga.backend.models.Especialidad;

public interface EspecialidadService {
    List<Especialidad> findAll();
    Optional<Especialidad> findById(Long id);
    Especialidad save(Especialidad especialidad);
    void deleteById(Long id);
}
