package com.rga.backend.security;

import io.jsonwebtoken.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String jwtSecret = "TuClaveSecreta"; // 🔒 Cambia esto por una clave segura
    private final int jwtExpirationInMs = 604800000; // 🕒 7 días de duración

    // 🔹 Genera un token JWT
    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        System.out.println("Aurorities del user:" + userDetails.getAuthorities());

        String role = userDetails.getAuthorities().stream()
                    .findFirst()
                    .map(GrantedAuthority::getAuthority)
                    .orElse("ROLE_ADMIN");

        System.out.println("Rol" + role);
        Long idUsuario = null;
        Long idEspecialidad = null;

        System.out.println("Tipo de userDetails: " + userDetails.getClass().getName());

        if(userDetails instanceof CustomUserDetails){
            CustomUserDetails customUserDetails = (CustomUserDetails) userDetails;
            idUsuario = customUserDetails.getIdUsuario();
            idEspecialidad = customUserDetails.getIdEspecialidad();

        } else {
            System.out.println("userDetails NO es una instancia de CustomUserDetails");
        }
        
        System.out.println("idUsuario: " + idUsuario); 
        System.out.println("idEspecialidad: " + idEspecialidad); 

        return Jwts.builder()
                .setSubject(userDetails.getUsername()) // El sujeto es el username
                .claim("role", role)
                .claim("idUsuario", idUsuario)
                .claim("idEspecialidad", idEspecialidad)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret) // Firmar con HS512
                .compact();

    }

    // 🔹 Obtiene el username desde el token
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // 🔹 Valida si el token es correcto
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            System.out.println("JWT no válido: " + e.getMessage());
        }
        return false;
    }
}
