package com.cinn.grav.entidades;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "usuario_gestante")
public class UsuarioGestante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String nomeBebe;
    private String email;
    private LocalDate dataUltimaMenstruacao;
    private String emergenciaMedico;
    private String emergenciaFamilia;

    public UsuarioGestante(Integer id, String nome, String nomeBebe, String email, LocalDate dateUltimaMenstruacao, String emergenciaMedico, String emergenciaFamilia) {
        this.id = id;
        this.nome = nome;
        this.nomeBebe = nomeBebe;
        this.email = email;
        this.dataUltimaMenstruacao = dateUltimaMenstruacao;
        this.emergenciaMedico = emergenciaMedico;
        this.emergenciaFamilia = emergenciaFamilia;
    }

    public UsuarioGestante(String nome, String nomeBebe, String email, LocalDate dateUltimaMenstruacao, String emergenciaMedico, String emergenciaFamilia) {
        this.nome = nome;
        this.nomeBebe = nomeBebe;
        this.email = email;
        this.dataUltimaMenstruacao = dateUltimaMenstruacao;
        this.emergenciaMedico = emergenciaMedico;
        this.emergenciaFamilia = emergenciaFamilia;
    }

    public UsuarioGestante() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEmergenciaMedico() {
        return this.emergenciaMedico;
    }

    public String getEmergenciaFamilia() {
        return this.emergenciaFamilia;
    }
}
