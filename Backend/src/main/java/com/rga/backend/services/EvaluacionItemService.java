package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import com.rga.backend.models.EvaluacionItem;

public interface EvaluacionItemService {
    List<EvaluacionItem> findAll();
    Optional<EvaluacionItem> findById(Long id);
    EvaluacionItem save(EvaluacionItem evaluacionItem);
    void deleteById(Long id);

}
