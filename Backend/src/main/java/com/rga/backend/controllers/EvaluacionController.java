package com.rga.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rga.backend.models.Evaluacion;
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

    @GetMapping("/{id}")
    public Optional<Evaluacion> getEvaluacionById(@PathVariable Long id){
        return evaluacionService.findById(id);
    }

    @PostMapping
    public Evaluacion createEvaluacion(@RequestBody Evaluacion evaluacion){
        return evaluacionService.save(evaluacion);
    }

}

