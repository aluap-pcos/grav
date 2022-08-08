package com.cinn.grav.utils.form;

import com.cinn.grav.entidades.Anotacao;
import com.cinn.grav.entidades.Consulta;
import com.cinn.grav.entidades.Endereco;
import com.cinn.grav.utils.Datautils;
import com.cinn.grav.service.EnderecoService;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;

public class ConsultaForm {
    private String nomeClinica;
    @NotNull
    private String nomeMedico;
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")
    private String contatoClinica;
    @NotNull
    //TODO Montar regex
    @Pattern(regexp = "")
    private String dataConsulta;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;


    public ConsultaForm(String nomeClinica, String nomeMedico, String contatoClinica, String dataConsulta, String rua, String numero, String bairro, String complemento, String cidade, String estado) {
        this.nomeClinica = nomeClinica;
        this.nomeMedico = nomeMedico;
        this.contatoClinica = contatoClinica;
        this.dataConsulta = dataConsulta;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public ConsultaForm() {
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

    public String getDataConsulta() {
        return dataConsulta;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Consulta converter(){
        Endereco endereco = null;
        if(rua != null && numero != null && bairro != null && cidade != null && estado != null) {
            endereco = new EnderecoService().adicionaEndereco(rua, numero, bairro, complemento, cidade, estado);
        }
        Consulta consulta = new Consulta(nomeClinica,nomeMedico,contatoClinica, endereco,
                Datautils.convertDateTime(dataConsulta), new Anotacao(new ArrayList<>(), ""));
        return consulta;
    }
}
