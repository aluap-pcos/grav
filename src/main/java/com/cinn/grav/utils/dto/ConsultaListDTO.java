package com.cinn.grav.utils.dto;

import com.cinn.grav.entidades.Consulta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaListDTO {
    private Integer id;
    private String nomeClinica;
    private LocalDateTime dataEHora;
    private boolean realizada;

    public ConsultaListDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.nomeClinica = consulta.getNomeClinica();
        this.dataEHora = consulta.getDataConsulta();
        this.realizada = consulta.isRealizda();
    }

    public ConsultaListDTO() {
    }

    public Integer getId() {
        return id;
    }

    public String getNomeClinica() {
        return nomeClinica;
    }

    public LocalDateTime getDataEHora() {
        return dataEHora;
    }

    public boolean getRealizada() {
        return realizada;
    }

    public static List<ConsultaListDTO> convert(List<Consulta> consultas){
        return consultas.stream().map(ConsultaListDTO::new).collect(Collectors.toList());
    }
}
