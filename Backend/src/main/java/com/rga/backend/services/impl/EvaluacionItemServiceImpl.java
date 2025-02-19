package com.rga.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.backend.models.EvaluacionItem;
import com.rga.backend.repositories.EvaluacionItemRepository;
import com.rga.backend.services.EvaluacionItemService;

@Service
public class EvaluacionItemServiceImpl implements EvaluacionItemService{
    @Autowired
    private EvaluacionItemRepository repository;

    @Override
    public List<EvaluacionItem> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<EvaluacionItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public EvaluacionItem save(EvaluacionItem evaluacionItem) {
        return repository.save(evaluacionItem);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
