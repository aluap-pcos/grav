package com.cinn.grav.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sintoma")
public class Sintoma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private boolean emergencia;

    @OneToMany(mappedBy = "sintoma", fetch = FetchType.LAZY)
    private List<SintomaGestante> sintomaGestantes;


    public String getNome() {
        return this.nome;
    }

    public boolean isEmergencia() {
        return this.emergencia;
    }

}
