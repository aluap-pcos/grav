package com.cinn.grav.entidades;

import com.cinn.grav.utils.AreaServico;

import javax.persistence.*;

@Entity
@Table(name = "usuario_anunciante")
public class UsuarioAnunciante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cpf;
    private String email;
    private String nome;
    private AreaServico areaServico;
    private String plano;
    private String contato;
    @OneToOne
    private Endereco endereco;
    @OneToOne
    private PerfilAnunciante perfil;

    public UsuarioAnunciante(String cpf, String email, String nome, AreaServico areaServico, String plano, String contato, Endereco endereco, PerfilAnunciante perfil) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.areaServico = areaServico;
        this.plano = plano;
        this.contato = contato;
        this.endereco = endereco;
        this.perfil = perfil;
    }

    public UsuarioAnunciante(String email, String nome, AreaServico areaServico, String plano, String contato, Endereco endereco, PerfilAnunciante perfil) {
        this.email = email;
        this.nome = nome;
        this.areaServico = areaServico;
        this.plano = plano;
        this.contato = contato;
        this.endereco = endereco;
        this.perfil = perfil;
    }

    public UsuarioAnunciante() {
    }
}
