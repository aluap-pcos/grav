package com.cinn.grav.entidades;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @ManyToMany(mappedBy = "perfis")
    List<Usuario> usuarios;

    public Perfil(Integer id, String nome, List<Usuario> usuarios) {
        this.id = id;
        this.nome = nome;
        this.usuarios = usuarios;
    }

    public Perfil() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getAuthority() {
        return nome;
    }
}
