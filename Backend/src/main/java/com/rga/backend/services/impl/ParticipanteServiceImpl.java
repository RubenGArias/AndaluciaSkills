package com.rga.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.backend.models.Participante;
import com.rga.backend.repositories.ParticipanteRepository;
import com.rga.backend.services.ParticipanteService;

@Service
public class ParticipanteServiceImpl implements ParticipanteService{
    @Autowired
    private ParticipanteRepository repository;

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

}
