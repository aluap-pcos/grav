package com.cinn.grav.entidades;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;
    private String senha;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_perfis",
    joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "perfil_id", referencedColumnName = "id"))
    private List<Perfil> perfis;

    public Usuario(Integer id, String email, String senha, List<Perfil> perfis) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.perfis = perfis;
    }

    public Usuario(String email, String senha, List<Perfil> perfis) {
        this.email = email;
        this.senha = senha;
        this.perfis = perfis;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfis;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil);
    }
}
