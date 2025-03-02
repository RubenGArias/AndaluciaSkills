package com.rga.backend.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.rga.backend.models.Prueba;

public interface PruebaService {
    List<Prueba> findAll();
    Optional<Prueba> findById(Long id);
    Prueba save(Prueba prueba);
    void deleteById(Long id); 
    List<Prueba> findByEspecialidadId(Long id);
    Prueba crearPrueba(MultipartFile enunciadoPdf, int puntuacionMaxima, Long idEspecialidad) throws IOException;

}
