package com.rga.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rga.backend.models.Evaluacion;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long>{

}
