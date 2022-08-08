package com.cinn.grav.utils.dto;

import com.cinn.grav.entidades.Anotacao;

import java.util.List;

public class AnotacaoDTO {
    private Integer id;
    private List<SintomaListDTO> sintomas;
    private String texto;
    private Integer consultaId;

    public AnotacaoDTO(Anotacao anotacao) {
        this.id = anotacao.getId();
        this.sintomas = SintomaListDTO.convert(anotacao.getSintomas());
        this.texto = anotacao.getTexto();
        this.consultaId = anotacao.getConsultaId();
    }

    public AnotacaoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public List<SintomaListDTO> getSintomas() {
        return sintomas;
    }

    public String getTexto() {
        return texto;
    }

    public Integer getConsultaId() {
        return consultaId;
    }
}
