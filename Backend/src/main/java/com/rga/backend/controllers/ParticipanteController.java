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

import com.rga.backend.models.Participante;
import com.rga.backend.services.ParticipanteService;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public List<Participante> getAllParticipantes(){
        return participanteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Participante> getParticipanteById(@PathVariable Long id){
        return participanteService.findById(id);
    }

    @PostMapping
    public Participante createParticipante(@RequestBody Participante participante){
        return participanteService.save(participante);
    }

}
