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
@Table(name = "Evaluacion_Item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluacionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvaluacion_Item")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEvaluacion")
    private Evaluacion evaluacion;

    @ManyToOne
    @JoinColumn(name = "idItem")
    private Item item;

    private int valoracion;
    private String explicacion;


}
