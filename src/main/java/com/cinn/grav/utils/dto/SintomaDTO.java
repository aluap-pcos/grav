package com.cinn.grav.utils.dto;

import com.cinn.grav.entidades.Sintoma;
import com.cinn.grav.entidades.SintomaGestante;

public class SintomaDTO {
    private Integer id;
    private String nomeSintoma;
    private boolean emergencia;
    private Integer intensidade;
    private Integer anotacaoId;

    public SintomaDTO(SintomaGestante sintoma) {
        this.id = sintoma.getId();
        this.nomeSintoma = sintoma.getNomeSintoma();
        this.emergencia = sintoma.isEmergencia();
        this.intensidade = sintoma.getIntensidade();
        this.anotacaoId = sintoma.getAnotacaoId();
    }

    public SintomaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public String getNomeSintoma() {
        return nomeSintoma;
    }

    public boolean isEmergencia() {
        return emergencia;
    }

    public Integer getIntensidade() {
        return intensidade;
    }

    public Integer getAnotacaoId() {
        return anotacaoId;
    }
}
