package com.cinn.grav.entidades;

import javax.persistence.*;

@Entity
@Table(name = "tipo_exame")
public class TipoExame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String preparo;

    public TipoExame(Integer id, String nome, String preparo) {
        this.id = id;
        this.nome = nome;
        this.preparo = preparo;
    }

    public TipoExame(String nome, String preparo) {
        this.nome = nome;
        this.preparo = preparo;
    }

    public TipoExame() {
    }

    public String getNomeExame() {
        return this.nome;
    }

    public String getPreparo() {
        return this.preparo;
    }
}
