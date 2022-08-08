package com.cinn.grav.entidades;

import com.cinn.grav.utils.form.SintomaForm;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sintoma_gestante")
public class SintomaGestante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sintoma", referencedColumnName = "id")
    private Sintoma sintoma;

    private Integer intensidade;
    private LocalDateTime dataSintoma;

    @ManyToOne
    @JoinColumn(name = "anotacao", referencedColumnName = "id")
    private Anotacao anotacao;

    public SintomaGestante(Sintoma sintoma, Integer intensidade, LocalDateTime dataSintoma, Anotacao anotacao) {
        this.sintoma = sintoma;
        this.intensidade = intensidade;
        this.dataSintoma = dataSintoma;
        this.anotacao = anotacao;
    }

    public SintomaGestante() {
    }

    public Integer getId() {
        return id;
    }

    public String getNomeSintoma() {
        return sintoma.getNome();
    }

    public boolean isEmergencia(){
        return sintoma.isEmergencia();
    }

    public Integer getIntensidade() {
        return intensidade;
    }

    public LocalDateTime getDataSintoma(){
        return this.dataSintoma;
    }

    public Integer getAnotacaoId(){
        return anotacao.getId();
    }
}
