package com.rga.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rga.backend.models.Item;
import com.rga.backend.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id){
        return itemService.findById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemService.save(item);
    }

    

}
