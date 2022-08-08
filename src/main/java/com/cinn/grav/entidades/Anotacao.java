package com.cinn.grav.entidades;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "anotacao")
public class Anotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anotacao")
    private List<SintomaGestante> sintomas;

    private String texto;

    @OneToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id")
    private Consulta consulta;

    public Anotacao(List<SintomaGestante> sintomas, String texto) {
        this.sintomas = sintomas;
        this.texto = texto;
    }

    public Anotacao() {
    }

    public Integer getId() {
        return  this.id;
    }

    public List<SintomaGestante> getSintomas(){
        return Collections.unmodifiableList(this.sintomas);
    }

    public String getTexto(){
        return this.texto;
    }

    public Integer getConsultaId(){
        return this.consulta.getId();
    }

    public void setSintomas(List<SintomaGestante> sintomas){
        if(this.sintomas.isEmpty()){
            this.sintomas = sintomas;
        }
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public void adicionaSintomas(SintomaGestante sintomaGestante){
        this.sintomas.add(sintomaGestante);
    }
}
