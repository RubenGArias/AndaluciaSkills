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

import com.rga.backend.models.EvaluacionItem;
import com.rga.backend.services.EvaluacionItemService;

@RestController
@RequestMapping("/evaluacionesItems")
public class EvaluacionItemController {
    @Autowired
    private EvaluacionItemService service;

    @GetMapping
    public List<EvaluacionItem> getAllEvaluacionItems(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EvaluacionItem> getEvaluacionItemById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public EvaluacionItem createEvaluacionItem(@RequestBody EvaluacionItem evaluacionItem){
        return service.save(evaluacionItem);
    }


}
