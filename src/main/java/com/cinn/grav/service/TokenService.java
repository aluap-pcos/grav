package com.cinn.grav.service;

import com.cinn.grav.entidades.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TokenService {
    @Value("${grav.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication){
        Usuario logado = (Usuario) authentication.getAuthorities();
        LocalDate hoje = LocalDate.now();
        LocalDate expirarEm = hoje.plusYears(1);

        return Jwts.builder()
                .setIssuer("Aplicativo para gestantes")
                .setSubject(logado.getId().toString())
                .setIssuedAt(Date.from(hoje.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .setIssuedAt(Date.from(expirarEm.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Integer getUsuarioId(String token) {
        Claims claims = Jwts.parser().setSigningKey("").parseClaimsJws(token).getBody();
        return Integer.parseInt(claims.getSubject());
    }
}
