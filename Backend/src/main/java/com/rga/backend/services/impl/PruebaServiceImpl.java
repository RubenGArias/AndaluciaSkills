package com.rga.backend.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rga.backend.models.Especialidad;
import com.rga.backend.models.Prueba;
import com.rga.backend.repositories.EspecialidadRepository;
import com.rga.backend.repositories.PruebaRepository;
import com.rga.backend.services.PruebaService;

@Service
public class PruebaServiceImpl implements PruebaService{
    @Autowired
    private PruebaRepository repository;

    @Override
    public List<Prueba> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Prueba> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Prueba save(Prueba prueba) {
        return repository.save(prueba);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    public List<Prueba> findByEspecialidadId(Long id){
        return repository.findByEspecialidadId(id);
    }

        @Autowired
    private EspecialidadRepository especialidadRepository;

    private final String FILES_DIRECTORY = "files/";

    public Prueba crearPrueba(MultipartFile enunciadoPdf, int puntuacionMaxima, Long idEspecialidad) throws IOException {
        // Verificar si la especialidad existe
        Especialidad especialidad = especialidadRepository.findById(idEspecialidad)
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrada"));

        // Guardar el archivo PDF en el sistema de archivos
        String nombreArchivo = guardarArchivo(enunciadoPdf);

        // Crear la entidad Prueba
        Prueba prueba = new Prueba();
        prueba.setEnunciado(nombreArchivo); // Guardamos el nombre del archivo
        prueba.setPuntuacion_maxima(puntuacionMaxima);
        prueba.setEspecialidad(especialidad);

        // Guardar la prueba en la base de datos
        return repository.save(prueba);
    }

    private String guardarArchivo(MultipartFile archivo) throws IOException {
        // Generar un nombre único para el archivo
        String nombreArchivo = archivo.getOriginalFilename();

        // Crear la ruta completa del archivo
        Path rutaArchivo = Paths.get(FILES_DIRECTORY + nombreArchivo);

        // Guardar el archivo en el sistema de archivos
        Files.copy(archivo.getInputStream(), rutaArchivo);

        return nombreArchivo;
    }
    

}
