package com.cinn.grav.entidades;

import javax.persistence.*;

@Entity
@Table(name = "depoimento")
public class Depoimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String texto;
    @ManyToOne

    private UsuarioGestante gestante;

    @ManyToOne
    @JoinColumn(name = "perfil_anunciante", referencedColumnName = "id")
    private PerfilAnunciante perfil;

    public Depoimento(Integer id, String texto, UsuarioGestante gestante) {
        this.id = id;
        this.texto = texto;
        this.gestante = gestante;
    }

    public Depoimento(String texto, UsuarioGestante gestante) {
        this.texto = texto;
        this.gestante = gestante;
    }

    public Depoimento() {
    }
}
