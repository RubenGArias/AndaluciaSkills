package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import com.rga.backend.models.Item;

public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(Long  id);
    Item save(Item item);
    void deleteById(Long id);

}
