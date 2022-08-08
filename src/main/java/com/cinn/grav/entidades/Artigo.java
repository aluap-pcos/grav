package com.cinn.grav.entidades;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "artigo")
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titulo;
    private String texto;

    @ManyToOne()
    @JoinColumn(name = "tema", referencedColumnName = "id")
    private TemaArtigo tema;
    /*
    @ManyToOne
    @JoinColumn(name = "anunciante", referencedColumnName = "id")
    private Optional<UsuarioAnunciante> anunciante;
     */
    private boolean lido;

    public Artigo(Integer id, String titulo, String texto,  boolean lido) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.lido = lido;
    }

    public Artigo() {
    }

    public boolean foiLido(){
        return this.lido;
    }
}
