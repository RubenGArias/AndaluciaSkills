package com.rga.backend.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Evaluacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvaluacion")
    private Long id;

    private double notaFinal;
    
    @ManyToOne
    @JoinColumn(name = "idParticipante")
    private Participante participante;

    @ManyToOne
    @JoinColumn(name = "idPrueba")
    private Prueba prueba;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL)
    private List<EvaluacionItem> evaluacionItems;

}
