package com.rga.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rga.backend.models.Especialidad;
import com.rga.backend.services.EspecialidadService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> getAllEspecialidades(){
        return especialidadService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Especialidad> getEspecialidadById(@PathVariable Long id){
        return especialidadService.findById(id);
    }

    @PostMapping
    public Especialidad createEspecialidad(@RequestBody Especialidad especialidad){
        return especialidadService.save(especialidad);
    }

}
