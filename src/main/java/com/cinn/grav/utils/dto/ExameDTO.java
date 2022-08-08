package com.cinn.grav.utils.dto;

import com.cinn.grav.entidades.Endereco;
import com.cinn.grav.entidades.Exame;

import java.time.LocalDateTime;

public class ExameDTO {
    private Integer id;
    private String nomeExame;
    private String preparoExame;
    private boolean realizado;
    private Endereco endereco;
    private LocalDateTime dataExame;
    private Integer idConsulta;

    public ExameDTO(Exame exame){
        this.id = exame.getId();
        this.nomeExame = exame.getNomeExame();
        this.preparoExame = exame.getPreparo();
        this.realizado = exame.isRealizada();
        this.endereco = exame.getEndereco();
        this.dataExame = exame.getDataExame();
        this.idConsulta = exame.getIdConsulta();
    }

    public Integer getId() {
        return id;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public String getPreparoExame() {
        return preparoExame;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public LocalDateTime getDataExame() {
        return dataExame;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }
}
