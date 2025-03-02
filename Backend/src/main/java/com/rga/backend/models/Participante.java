package com.rga.backend.models;

import jakarta.persistence.CascadeType;
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
@Table(name ="participante") //TODO Ver si la mayuscula del principio es necesaria
@Builder
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
    @JoinColumn(name = "idEspecialidad", nullable = false)
    private Especialidad especialidad;


}
