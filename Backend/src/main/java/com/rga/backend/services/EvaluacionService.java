package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import com.rga.backend.models.Evaluacion;
import com.rga.backend.models.Item;
import com.rga.backend.models.Prueba;
import com.rga.backend.requests.EvaluacionRequest;

public interface EvaluacionService {
    List<Evaluacion> findAll();
    Optional<Evaluacion> findById(Long id);
    Evaluacion save(Evaluacion evaluacion);
    void deleteById(Long id);
    List<Item> getItemsByPrueba(Long idPrueba);
    List<Prueba> getPruebasByEspecialidad(Long idEspecialidad);
    Evaluacion getEvaluacionByParticipante(Long idParticipante);
    void saveEvaluacion(EvaluacionRequest evaluacionRequest);

}
