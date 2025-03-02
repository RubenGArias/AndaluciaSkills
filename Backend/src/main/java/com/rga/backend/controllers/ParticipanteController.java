package com.rga.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rga.backend.models.Participante;
import com.rga.backend.requests.ParticipanteRequest;
import com.rga.backend.services.ParticipanteService;

@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public List<Participante> getAllParticipantes(){
        return participanteService.findAll();
    }

    @GetMapping("/participante/{id}")
    public Optional<Participante> getParticipanteById(@PathVariable Long id){
        return participanteService.findById(id);
    }

    @PostMapping("/add-participante")
    public ResponseEntity<?> createParticipante(@RequestBody ParticipanteRequest request) {
        return participanteService.crear(request);
    }

    @GetMapping("/especialidad/{idEspecialidad}")
    public ResponseEntity<List<Participante>> getParticipantesByEspecialidad(@PathVariable Long idEspecialidad){
        List<Participante> participantes = participanteService.findByEspecialidadId(idEspecialidad);
        if(participantes.isEmpty()){
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(participantes);
    }

    //@GetMapping("/misma-especialidad")


    

}
