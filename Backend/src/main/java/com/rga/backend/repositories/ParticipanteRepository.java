package com.rga.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rga.backend.models.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long>{

}
