package com.rga.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String role;
    private String dni;
    private String nombre;
    private String apellidos;
    private Long idEspecialidad;

}
