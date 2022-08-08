package com.cinn.grav.utils.dto;

import com.cinn.grav.entidades.Exame;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExameListDTO {
    private String nomeExame;
    private LocalDateTime dataExame;
    private boolean realizado;

    public ExameListDTO(Exame exame) {
        this.nomeExame = exame.getNomeExame();
        this.dataExame = exame.getDataExame();
        this.realizado = exame.isRealizada();
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public LocalDateTime getDataExame() {
        return dataExame;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public static List<ExameListDTO> convert(List<Exame> exames){
        return exames.stream().map(ExameListDTO::new).collect(Collectors.toList());
    }
}
