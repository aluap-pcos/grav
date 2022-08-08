package com.cinn.grav.utils.form;

import com.cinn.grav.entidades.Anotacao;
import com.cinn.grav.entidades.Consulta;
import com.cinn.grav.entidades.SintomaGestante;
import com.cinn.grav.repositorios.ConsultaRepository;
import com.cinn.grav.service.AnotacaoService;
import com.cinn.grav.utils.exceptions.ConsultaNaoExisteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnotacaoForm {
    private String texto;
    private List<SintomaForm> sintomas;
    private Integer consultaId;

    public AnotacaoForm(String texto, List<SintomaForm> sintomas, Integer consultaId) {
        this.texto = texto;
        this.sintomas = sintomas;
        this.consultaId = consultaId;
    }

    public AnotacaoForm() {
    }

    public String getTexto() {
        return texto;
    }

    public List<SintomaForm> getSintomas() {
        return sintomas;
    }

    public Integer getConsultaId() {
        return consultaId;
    }

}
