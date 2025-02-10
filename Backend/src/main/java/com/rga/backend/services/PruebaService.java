package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import com.rga.backend.models.Prueba;

public interface PruebaService {
    List<Prueba> findAll();
    Optional<Prueba> findById(Long id);
    Prueba save(Prueba prueba);
    void deleteById(Long id); 

}
