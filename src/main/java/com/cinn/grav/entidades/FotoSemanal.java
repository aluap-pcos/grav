package com.cinn.grav.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foto_semanal")
public class FotoSemanal {
    @Id
    private Integer semana;
    private Byte foto;
    private String descricao;

    public FotoSemanal(Integer semana, Byte foto, String descricao) {
        this.semana = semana;
        this.foto = foto;
        this.descricao = descricao;
    }

    public FotoSemanal() {
    }
}
