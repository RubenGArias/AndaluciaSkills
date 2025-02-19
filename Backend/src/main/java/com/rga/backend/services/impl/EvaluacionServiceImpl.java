package com.rga.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.backend.models.Evaluacion;
import com.rga.backend.repositories.EvaluacionRepository;
import com.rga.backend.services.EvaluacionService;

@Service
public class EvaluacionServiceImpl implements EvaluacionService{
    @Autowired
    private EvaluacionRepository repository;

    @Override
    public List<Evaluacion> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Evaluacion> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Evaluacion save(Evaluacion evaluacion) {
        return repository.save(evaluacion);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
