package com.cinn.grav.entidades;

import javax.persistence.*;

@Entity
@Table(name = "texto_semanal")
public class TextoSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer semana;
    private String titulo;
    private String texto;

    public TextoSemanal(Integer semana, String titulo, String texto) {
        this.semana = semana;
        this.titulo = titulo;
        this.texto = texto;
    }

    public TextoSemanal(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public TextoSemanal() {
    }
}
