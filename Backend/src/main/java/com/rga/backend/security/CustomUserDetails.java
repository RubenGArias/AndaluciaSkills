package com.rga.backend.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rga.backend.models.User;


public class CustomUserDetails implements UserDetails{
    private String username;
    private String password;
    private Long idUsuario;
    private Long idEspecialidad;
    private List<GrantedAuthority> authorities;


    public CustomUserDetails(String username, String password, String role, Long idUsuario, Long idEspecialidad) {
        this.username = username;
        this.password = password;
        this.idUsuario = idUsuario;
        this.idEspecialidad = idEspecialidad;
        this.authorities = List.of(new SimpleGrantedAuthority(role));
    }

    public CustomUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.idUsuario = user.getId();
        this.idEspecialidad = user.getEspecialidad().getId();
        this.authorities = List.of(new SimpleGrantedAuthority(user.getRole())); // Asignar rol
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }

    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdEspecialidad() {
        return idEspecialidad;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }


}
