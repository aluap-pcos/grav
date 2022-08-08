package com.cinn.grav.utils.form;

import com.cinn.grav.entidades.Consulta;
import com.cinn.grav.entidades.Endereco;
import com.cinn.grav.entidades.Exame;
import com.cinn.grav.entidades.TipoExame;
import com.cinn.grav.repositorios.ConsultaRepository;
import com.cinn.grav.repositorios.TipoExameRepository;
import com.cinn.grav.utils.Datautils;
import com.cinn.grav.service.EnderecoService;

import javax.validation.constraints.NotNull;

public class ExameForm {
    @NotNull
    private String tipoExameId;
    @NotNull
    private String consultaId;
    private String dataExame;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;

    public ExameForm(String tipoExameId, String consultaId, String dataExame, String rua, String numero, String bairro, String complemento, String cidade, String estado) {
        this.tipoExameId = tipoExameId;
        this.consultaId = consultaId;
        this.dataExame = dataExame;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public ExameForm() {
    }

    public String getTipoExameId() {
        return tipoExameId;
    }

    public String getConsultaId() {
        return consultaId;
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

    public Exame converter(ConsultaRepository consultaRepository, TipoExameRepository tipoExameRepository){
        Endereco endereco = null;
        if(rua != null && numero != null && bairro != null && cidade != null && estado != null) {
            endereco = new EnderecoService().adicionaEndereco(rua, numero, bairro, complemento, cidade, estado);
        }
        TipoExame tipoExame = tipoExameRepository.findById(Integer.parseInt(tipoExameId)).get();
        Consulta consulta = consultaRepository.findById(Integer.parseInt(consultaId)).get();

        Exame exame = new Exame(tipoExame, endereco, Datautils.convertDateTime(dataExame), consulta, false);
        consulta.adicionaExame(exame);

        return exame;
    }
}
