package com.cinn.grav.utils.dto;

import com.cinn.grav.entidades.UsuarioGestante;

import java.time.LocalDate;

public class GestanteDTO {
    private Integer id;
    private String nome;
    private String email;
    private String emergenciaMedico;
    private String emergenciaFamilia;

    public GestanteDTO(UsuarioGestante usuarioGestante) {
        this.id = usuarioGestante.getId();
        this.nome = usuarioGestante.getNome();
        this.email = usuarioGestante.getEmail();
        this.emergenciaMedico = usuarioGestante.getEmergenciaMedico();
        this.emergenciaFamilia = usuarioGestante.getEmergenciaFamilia();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEmergenciaMedico() {
        return emergenciaMedico;
    }

    public String getEmergenciaFamilia() {
        return emergenciaFamilia;
    }
}
