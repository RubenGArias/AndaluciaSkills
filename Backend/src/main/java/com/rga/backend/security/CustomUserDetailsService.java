package com.rga.backend.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rga.backend.models.User;
import com.rga.backend.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;

    public CustomUserDetailsService( UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado:" + username));
                return new CustomUserDetails(user);
    }

}
