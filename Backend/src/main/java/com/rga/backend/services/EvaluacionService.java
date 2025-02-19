package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import com.rga.backend.models.Evaluacion;

public interface EvaluacionService {
    List<Evaluacion> findAll();
    Optional<Evaluacion> findById(Long id);
    Evaluacion save(Evaluacion evaluacion);
    void deleteById(Long id);

}
