package com.cinn.grav.utils.dto;


import com.cinn.grav.entidades.SintomaGestante;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SintomaListDTO {
    private Integer id;
    private String nomeSintoma;
    private LocalDate dataSintoma;

    public SintomaListDTO(SintomaGestante sintomaGestante) {
        this.id = sintomaGestante.getId();
        this.nomeSintoma = sintomaGestante.getNomeSintoma();
        this.dataSintoma = sintomaGestante.getDataSintoma().toLocalDate();
    }

    public SintomaListDTO() {
    }

    public Integer getId() {
        return id;
    }

    public String getNomeSintoma() {
        return nomeSintoma;
    }

    public LocalDate getDataSintoma() {
        return dataSintoma;
    }

    public static List<SintomaListDTO> convert(List<SintomaGestante> sintomas){
        return sintomas.stream().map(SintomaListDTO::new).collect(Collectors.toList());
    }
}
