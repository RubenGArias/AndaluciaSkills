package com.rga.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rga.backend.models.EvaluacionItem;

@Repository
public interface EvaluacionItemRepository extends JpaRepository<EvaluacionItem, Long>{

}
