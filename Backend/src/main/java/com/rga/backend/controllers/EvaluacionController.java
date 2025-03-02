package com.rga.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rga.backend.models.Evaluacion;
import com.rga.backend.models.Item;
import com.rga.backend.models.Prueba;
import com.rga.backend.requests.EvaluacionRequest;
import com.rga.backend.services.EvaluacionService;


@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {
    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public List<Evaluacion> getAllEvaluaciones(){
        return evaluacionService.findAll();
    }

    @GetMapping("/pruebas")
    public ResponseEntity<List<Prueba>> getPruebasByEspecialidad(@RequestParam Long idEspecialidad) {
        List<Prueba> pruebas = evaluacionService.getPruebasByEspecialidad(idEspecialidad);
        return ResponseEntity.ok(pruebas);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItemsByPrueba(@RequestParam Long idPrueba) {
        List<Item> items = evaluacionService.getItemsByPrueba(idPrueba);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/participante/{idParticipante}")
    public ResponseEntity<Evaluacion> getEvaluacionByParticipante(@PathVariable Long idParticipante){
        Evaluacion evaluacion = evaluacionService.getEvaluacionByParticipante(idParticipante);
        return ResponseEntity.ok(evaluacion);
    }

    @GetMapping("/{id}")
    public Optional<Evaluacion> getEvaluacionById(@PathVariable Long id){
        return evaluacionService.findById(id);
    }

@PostMapping("/save")
public ResponseEntity<?> saveEvaluacion(@RequestBody EvaluacionRequest evaluacionRequest) {
    try {
        evaluacionService.saveEvaluacion(evaluacionRequest);
        return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
    }
}
}

