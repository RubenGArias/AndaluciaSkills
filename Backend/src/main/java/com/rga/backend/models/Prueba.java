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
@Table(name ="prueba")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("idPrueba"))
    private Long id;

    private String enunciado;
    private Integer puntuacion_maxima;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

}
