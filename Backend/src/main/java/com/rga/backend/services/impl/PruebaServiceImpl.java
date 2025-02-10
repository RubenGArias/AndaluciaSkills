package com.rga.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rga.backend.models.Prueba;
import com.rga.backend.repositories.PruebaRepository;
import com.rga.backend.services.PruebaService;

@Service
public class PruebaServiceImpl implements PruebaService{
    private PruebaRepository repository;

    @Override
    public List<Prueba> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Prueba> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Prueba save(Prueba prueba) {
        return repository.save(prueba);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    

}
