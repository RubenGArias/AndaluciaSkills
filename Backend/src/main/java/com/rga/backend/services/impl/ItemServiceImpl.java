package com.rga.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.backend.models.Item;
import com.rga.backend.models.Prueba;
import com.rga.backend.repositories.ItemRepository;
import com.rga.backend.repositories.PruebaRepository;
import com.rga.backend.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository repository;
    @Autowired PruebaRepository pruebaRepository;

    @Override
    public List<Item> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    public Item save(Item item, Long idPrueba) {
        // Buscar la Prueba por su id
        Prueba prueba = pruebaRepository.findById(idPrueba)
                .orElseThrow(() -> new RuntimeException("Prueba no encontrada"));

        // Asignar la Prueba al Item
        item.setPrueba(prueba);

        // Guardar el Item en la base de datos
        return repository.save(item);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Item> findByPruebaId(Long id){
        return repository.findByPruebaId(id);
    }
    

}
