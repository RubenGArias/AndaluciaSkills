package com.rga.backend.mapper;


import com.rga.backend.dto.UserDTO;
import com.rga.backend.models.User;

public class UserMapper {
    public static UserDTO toDTO(User user){
        return new UserDTO(
            user.getRole(),
            user.getUsername(),
            user.getDni(),
            user.getNombre(),
            user.getApellidos(),
            user.getEspecialidad() != null ? user.getEspecialidad().getId() : null
        );   
    }


    public static User toModel(UserDTO userDTO){
        User user = new User();
        user.setRole(userDTO.getRole());
        user.setUsername(userDTO.getUsername());
        user.setDni(userDTO.getDni());
        user.setNombre(userDTO.getNombre());
        user.setApellidos(userDTO.getApellidos());

        return user;
    }

}
