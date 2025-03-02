package com.rga.backend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.backend.models.Evaluacion;
import com.rga.backend.models.EvaluacionItem;
import com.rga.backend.models.Item;
import com.rga.backend.models.Participante;
import com.rga.backend.models.Prueba;
import com.rga.backend.models.User;
import com.rga.backend.repositories.EvaluacionRepository;
import com.rga.backend.repositories.ItemRepository;
import com.rga.backend.repositories.ParticipanteRepository;
import com.rga.backend.repositories.PruebaRepository;
import com.rga.backend.repositories.UserRepository;
import com.rga.backend.requests.EvaluacionPruebaRequest;
import com.rga.backend.requests.EvaluacionRequest;
import com.rga.backend.services.EvaluacionService;

import jakarta.transaction.Transactional;

@Service
public class EvaluacionServiceImpl implements EvaluacionService{
    @Autowired
    private EvaluacionRepository repository;
    @Autowired
    private PruebaRepository pruebaRepository;
    @Autowired 
    private ItemRepository itemRepository;
    @Autowired
    private ParticipanteRepository participanteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Override
    public List<Evaluacion> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Evaluacion> findById(Long id) {
        return repository.findById(id);
    }

@Override
public Evaluacion save(Evaluacion evaluacion) {
    // Validar que los campos obligatorios no sean nulos
    if (evaluacion.getParticipante() == null || evaluacion.getPrueba() == null || evaluacion.getUser() == null) {
        throw new IllegalArgumentException("Los datos de participante, prueba y usuario son obligatorios.");
    }

    // Verificar que los IDs existan en las tablas relacionadas
    if (!participanteRepository.existsById(evaluacion.getParticipante().getId())) {
        throw new IllegalArgumentException("El participante no existe.");
    }
    if (!pruebaRepository.existsById(evaluacion.getPrueba().getId())) {
        throw new IllegalArgumentException("La prueba no existe.");
    }
    if (!userRepository.existsById(evaluacion.getUser().getId())) {
        throw new IllegalArgumentException("El usuario no existe.");
    }

    // Asociar cada ítem a la evaluación
    if (evaluacion.getEvaluacionItems() != null) {
        for (EvaluacionItem item : evaluacion.getEvaluacionItems()) {
            item.setEvaluacion(evaluacion); // Asocia el ítem con la evaluación
        }
    }

    // Guardar la evaluación
    return repository.save(evaluacion);
}

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Item> getItemsByPrueba(Long idPrueba) {
        return itemRepository.findByPruebaId(idPrueba);
    }

    @Override
    public List<Prueba> getPruebasByEspecialidad(Long idEspecialidad) {
        return pruebaRepository.findByEspecialidadId(idEspecialidad);
    }

    public Evaluacion getEvaluacionByParticipante(Long idParticipante) {
        return repository.findByParticipanteId(idParticipante).orElse(null);
    }

@Override
@Transactional
public void saveEvaluacion(EvaluacionRequest evaluacionRequest) {
    // Validar que los campos obligatorios no sean nulos
    if (evaluacionRequest.getIdParticipante() == null || evaluacionRequest.getIdUser() == null) {
        throw new IllegalArgumentException("Los datos de participante y usuario son obligatorios.");
    }

    // Obtener el participante y el usuario
    Participante participante = participanteRepository.findById(evaluacionRequest.getIdParticipante())
        .orElseThrow(() -> new IllegalArgumentException("El participante no existe."));
    User user = userRepository.findById(evaluacionRequest.getIdUser())
        .orElseThrow(() -> new IllegalArgumentException("El usuario no existe."));

    // Procesar cada evaluación de prueba
    for (EvaluacionPruebaRequest evaluacionPrueba : evaluacionRequest.getEvaluaciones()) {
        // Obtener la prueba
        Prueba prueba = pruebaRepository.findById(evaluacionPrueba.getIdPrueba())
            .orElseThrow(() -> new IllegalArgumentException("La prueba no existe."));

        // Crear la entidad Evaluacion
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setParticipante(participante);
        evaluacion.setPrueba(prueba);
        evaluacion.setUser(user);

        // Crear y asociar los ítems
        List<EvaluacionItem> evaluacionItems = evaluacionPrueba.getItems().stream()
            .map(itemRequest -> {
                EvaluacionItem item = new EvaluacionItem();
                item.setItem(itemRepository.findById(itemRequest.getIdItem())
                    .orElseThrow(() -> new IllegalArgumentException("El ítem no existe.")));
                item.setValoracion(itemRequest.getValoracion());
                item.setEvaluacion(evaluacion); // Asocia el ítem con la evaluación
                return item;
            })
            .collect(Collectors.toList());

        evaluacion.setEvaluacionItems(evaluacionItems);

        // Guardar la evaluación
        evaluacionRepository.save(evaluacion);
    }
}

}
