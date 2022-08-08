package com.cinn.grav.utils.dto;

import com.cinn.grav.entidades.Consulta;
import com.cinn.grav.entidades.Endereco;

import java.time.LocalDateTime;

public class ConsultaDTO {
    private Integer id;
    private String nomeClinica;
    private String nomeMedico;
    private String contatoClinica;
    private Endereco endereco;
    private LocalDateTime dataConsulta;

    public ConsultaDTO(Consulta consulta){
        this.id = consulta.getId();
        this.nomeClinica = consulta.getNomeClinica();
        this.nomeMedico = consulta.getNomeMedico();
        this.contatoClinica = consulta.getContatoClinica();
        this.endereco = consulta.getEndereco();
        this.dataConsulta = consulta.getDataConsulta();
    }

    public ConsultaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public String getNomeClinica() {
        return nomeClinica;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getContatoClinica() {
        return contatoClinica;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }
}
