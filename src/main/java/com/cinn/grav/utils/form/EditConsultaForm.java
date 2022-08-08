package com.cinn.grav.utils.form;

import com.cinn.grav.entidades.Consulta;
import com.cinn.grav.repositorios.ConsultaRepository;
import com.cinn.grav.repositorios.EnderecoRepository;
import com.cinn.grav.service.EnderecoService;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class EditConsultaForm {
    private String nomeMedico;
    private String nomeClinica;
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")
    private String contatoClinica;
    private String dataConsulta;
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;

    public EditConsultaForm(String nomeMedico, String nomeClinica, String contatoClinica, String rua, String numero, String bairro, String complemento, String cidade, String estado) {
        this.nomeMedico = nomeMedico;
        this.nomeClinica = nomeClinica;
        this.contatoClinica = contatoClinica;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EditConsultaForm() {
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getNomeClinica() {
        return nomeClinica;
    }

    public void setNomeClinica(String nomeClinica) {
        this.nomeClinica = nomeClinica;
    }

    public String getContatoClinica() {
        return contatoClinica;
    }

    public void setContatoClinica(String contatoClinica) {
        this.contatoClinica = contatoClinica;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Consulta atualizar(Consulta consulta){
        if(nomeMedico != null){
            consulta.alteraNomeMedico(nomeMedico);
        }
        if(nomeClinica != null){
            consulta.alteraNomeClinica(nomeClinica);
        }
        if(contatoClinica != null){
            consulta.alteraContatoClinica(contatoClinica);
        }
        if(rua != null && numero != null && bairro != null && cidade != null && estado != null){
            consulta.alteraEndereco(new EnderecoService().altera(rua, numero, bairro, complemento, cidade, estado));
        }
        if(dataConsulta != null){
            consulta.alteraDataConsulta(LocalDateTime.of(Integer.parseInt(dataConsulta.substring(0,1)), Integer.parseInt(dataConsulta.substring(3,4)),
                    Integer.parseInt(dataConsulta.substring(5,8)), Integer.parseInt(dataConsulta.substring(10,11)), Integer.parseInt(dataConsulta.substring(12,13))));
        }

        return consulta;
    }
}
