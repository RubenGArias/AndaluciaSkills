package com.rga.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rga.backend.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    

}
