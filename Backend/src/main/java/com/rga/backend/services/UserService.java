package com.rga.backend.services;

import java.util.List;
import java.util.Optional;

import com.rga.backend.models.User;

public interface UserService {
    List <User> findAll();
    Optional <User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
}
