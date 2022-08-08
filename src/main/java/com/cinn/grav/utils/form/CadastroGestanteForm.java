package com.cinn.grav.utils.form;

import com.cinn.grav.service.GestanteService;
import com.cinn.grav.entidades.Perfil;
import com.cinn.grav.entidades.Usuario;
import com.cinn.grav.entidades.UsuarioGestante;
import com.cinn.grav.service.AuthService;
import com.cinn.grav.utils.exceptions.UsuarioJaExiste;

import java.util.ArrayList;
import java.util.List;

public class CadastroGestanteForm {
    private String email;
    private String senha;
    private String nome;
    private String nomeBebe;
    private String dataUltimaMenstruacao;
    private String emergenciaMedico;
    private String emergenciaFamilia;

    public CadastroGestanteForm(String email, String senha, String nome, String nomeBebe, String dataUltimaMenstruacao, String emergenciaMedico, String emergenciaFamilia) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.nomeBebe = nomeBebe;
        this.dataUltimaMenstruacao = dataUltimaMenstruacao;
        this.emergenciaMedico = emergenciaMedico;
        this.emergenciaFamilia = emergenciaFamilia;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeBebe() {
        return nomeBebe;
    }

    public String getDataUltimaMenstruacao() {
        return dataUltimaMenstruacao;
    }

    public String getEmergenciaMedico() {
        return emergenciaMedico;
    }

    public String getEmergenciaFamilia() {
        return emergenciaFamilia;
    }

    public UsuarioGestante converter(AuthService authService, GestanteService gestanteService) throws UsuarioJaExiste {
        List<Perfil> perfis = new ArrayList<>();

        authService.criar(new Usuario(email, senha, new ArrayList<>()), "GESTANTE");
        return gestanteService.criar(this);
    }
}
