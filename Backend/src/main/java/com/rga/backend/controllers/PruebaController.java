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

import com.rga.backend.models.Prueba;
import com.rga.backend.services.PruebaService;

@RestController
@RequestMapping("/pruebas")
public class PruebaController {
    @Autowired
    private PruebaService pruebaService;

    @GetMapping
    public List<Prueba> getAllPruebas(){
        return pruebaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Prueba> getPruebaById(@PathVariable Long id){
        return pruebaService.findById(id);
    }

    @PostMapping("/{id}")
    public Prueba createPrueba(@RequestBody Prueba prueba){
        return pruebaService.save(prueba);
    }

}
