package com.rga.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipanteDTO {
    private String nombre;
    private String apellidos;
    private String centro;
    private Long idEspecialidad;

}
