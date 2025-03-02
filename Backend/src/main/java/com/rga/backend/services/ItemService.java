package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import com.rga.backend.models.Item;

public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(Long  id);
    Item save(Item item, Long idPrueba);
    void deleteById(Long id);
    List<Item> findByPruebaId(Long id);


}
