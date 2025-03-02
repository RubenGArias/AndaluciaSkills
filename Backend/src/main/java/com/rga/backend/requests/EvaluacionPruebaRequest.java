package com.rga.backend.requests;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvaluacionPruebaRequest {
    private Long idPrueba;
    private List<EvaluacionItemRequest> items;

}
