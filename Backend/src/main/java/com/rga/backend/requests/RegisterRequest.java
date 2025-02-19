package com.rga.backend.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private String role;
    private String dni;
    private String nombre;
    private String apellidos;
    private Long idEspecialidad;

}
