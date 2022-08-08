package com.cinn.grav.utils.form;

import com.cinn.grav.entidades.Exame;
import com.cinn.grav.utils.Datautils;
import com.cinn.grav.service.EnderecoService;

public class EditExameForm {
    private String dataExame;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;

    public EditExameForm(String dataExame, String rua, String numero, String bairro, String complemento, String cidade, String estado) {
        this.dataExame = dataExame;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EditExameForm() {
    }

    public String getDataExame() {
        return dataExame;
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

    public Exame atualizar(Exame exame){
        if(dataExame != null){
            exame.alteraDataExame(Datautils.convertDateTime(dataExame));
        }
        if(rua != null && numero != null && bairro != null && cidade != null && estado != null){
            exame.alteraEndereco(new EnderecoService().altera(rua, numero, bairro, complemento, cidade, estado));
        }

        return exame;
    }
}
