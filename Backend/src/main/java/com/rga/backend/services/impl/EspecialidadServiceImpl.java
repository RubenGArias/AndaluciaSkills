package com.rga.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.backend.models.Especialidad;
import com.rga.backend.repositories.EspecialidadRepository;
import com.rga.backend.services.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
    @Autowired
    private EspecialidadRepository repository;

    @Override
    public List<Especialidad> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Especialidad> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        return repository.save(especialidad);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
