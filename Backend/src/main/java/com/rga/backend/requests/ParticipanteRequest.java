package com.rga.backend.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipanteRequest {
    private String nombre;
    private String apellidos;
    private String centro;
    private Long idEspecialidad;
}
