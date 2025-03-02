package com.rga.backend.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import org.springframework.web.multipart.MultipartFile;

import com.rga.backend.models.Especialidad;
import com.rga.backend.models.Prueba;
import com.rga.backend.services.EspecialidadService;
import com.rga.backend.services.PruebaService;

@RestController
@RequestMapping("/pruebas")
public class PruebaController {
    @Autowired
    private PruebaService pruebaService;

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public List<Prueba> getAllPruebas(){
        return pruebaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Prueba> getPruebaById(@PathVariable Long id){
        return pruebaService.findById(id);
    }

    @PostMapping("/create")
    public Prueba createPrueba(@RequestBody Prueba prueba){
        return pruebaService.save(prueba);
    }

@PostMapping("/add")
    public Prueba crearPrueba(@RequestParam("enunciadoPdf") MultipartFile enunciadoPdf,
                              @RequestParam("puntuacionMaxima") int puntuacionMaxima,
                              @RequestParam("idEspecialidad") Long idEspecialidad) throws IOException {
        return pruebaService.crearPrueba(enunciadoPdf, puntuacionMaxima, idEspecialidad);
    }




    @GetMapping("/especialidad/{id}")
    public List<Prueba> getPruebasByEspecialidad(@PathVariable Long id){
        return pruebaService.findByEspecialidadId(id);
    }

}
