package com.rga.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rga.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
