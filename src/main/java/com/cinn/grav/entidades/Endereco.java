package com.cinn.grav.entidades;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String rua;
    private Integer numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;


    @OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY)
    private Exame exame;

    @OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY)
    private Consulta consulta;

    public Endereco(Integer id, String rua, Integer numero, String bairro, String complemento, String cidade, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco(String rua, Integer numero, String bairro, String complemento, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {
    }
}
