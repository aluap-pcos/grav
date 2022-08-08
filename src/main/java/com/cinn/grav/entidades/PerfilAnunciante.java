package com.cinn.grav.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "perfil_anunciante")
public class PerfilAnunciante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descricao;
    private Byte foto;
    private Byte video;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Depoimento> depoimentos;

    public PerfilAnunciante(Integer id, String descricao, Byte foto, Byte video) {
        this.id = id;
        this.descricao = descricao;
        this.foto = foto;
        this.video = video;
    }

    public PerfilAnunciante(String descricao, Byte foto, Byte video) {
        this.descricao = descricao;
        this.foto = foto;
        this.video = video;
    }

    public PerfilAnunciante() {
    }
}
