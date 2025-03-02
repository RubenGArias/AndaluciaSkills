package com.rga.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rga.backend.models.Prueba;
import java.util.List;


@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long>{
    List<Prueba> findByEspecialidadId(Long id);

}
