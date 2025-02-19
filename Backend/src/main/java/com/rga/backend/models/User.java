package com.rga.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Builder
@Data //Lombok genera los getters y setters, constructor, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Long id;

    private String role;
    private String username;
    private String password;

    private String dni;
    private String nombre;
    private String apellidos;   


    @ManyToOne
    @JoinColumn(name = "idEspecialidad", nullable = false)
    private Especialidad especialidad;

}
