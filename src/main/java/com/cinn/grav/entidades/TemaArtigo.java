package com.cinn.grav.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tema_artigo")
public class TemaArtigo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "tema")
    private List<Artigo> artigos;

    public TemaArtigo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TemaArtigo() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
