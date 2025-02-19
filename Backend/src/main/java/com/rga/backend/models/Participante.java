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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Participante") //TODO Ver si la mayuscula del principio es necesaria
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParticipante")
    private Long id;

    private String nombre;
    private String apellidos;
    private String centro;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;


}
