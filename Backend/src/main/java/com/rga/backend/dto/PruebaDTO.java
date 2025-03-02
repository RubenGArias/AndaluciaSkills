package com.rga.backend.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PruebaDTO {
    private MultipartFile enunciadoPdf;
    private int puntuacionMaxima;
    private Long idEspecialdiad;
}
