package com.rga.backend.requests;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvaluacionRequest {
    private Long idParticipante;
    private Long idUser;

    private List<EvaluacionPruebaRequest> evaluaciones;

}
