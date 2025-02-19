package com.rga.backend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rga.backend.models.Item;
import com.rga.backend.repositories.ItemRepository;
import com.rga.backend.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    

}
