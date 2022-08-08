package com.cinn.grav.entidades;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nomeClinica;
    private String nomeMedico;
    private String contatoClinica;

    @OneToOne
    @JoinColumn(name = "endereco", referencedColumnName = "id")
    private Endereco endereco;

    private LocalDateTime dataConsulta;

    @OneToOne(mappedBy = "consulta")
    private Anotacao anotacao;

    @OneToMany(mappedBy = "consulta")
    private List<Exame> exames = new ArrayList<>();

    @ManyToOne
    private UsuarioGestante gestante;

    private boolean realizada;

    public Consulta(Integer id, String nomeClinica, String nomeMedico, String contatoClinica, Endereco endereco, LocalDateTime data, Anotacao anotacao) {
        this.id = id;
        this.nomeClinica = nomeClinica;
        this.nomeMedico = nomeMedico;
        this.contatoClinica = contatoClinica;
        this.endereco = endereco;
        this.dataConsulta = data;
        this.anotacao = anotacao;
    }

    public Consulta(String nomeClinica, String nomeMedico, String contatoClinica, Endereco endereco, LocalDateTime data, Anotacao anotacao) {
        this.nomeClinica = nomeClinica;
        this.nomeMedico = nomeMedico;
        this.contatoClinica = contatoClinica;
        this.endereco = endereco;
        this.dataConsulta = data;
        this.anotacao = anotacao;
    }

    public Consulta() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getNomeClinica() {
        return this.nomeClinica;
    }

    public LocalDateTime getDataConsulta() {
        return this.dataConsulta;
    }

    public boolean isRealizda() {
        return this.realizada;
    }

    public String getNomeMedico() {
        return this.nomeMedico;
    }

    public String getContatoClinica() {
        return this.contatoClinica;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void adicionaExame(Exame exame){
        this.exames.add(exame);
    }

    public void alteraNomeClinica(String nomeClinica) {
        this.nomeClinica = nomeClinica;
    }

    public void alteraNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public void alteraContatoClinica(String contatoClinica) {
        this.contatoClinica = contatoClinica;
    }

    public void alteraEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void alteraDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void adicionaAnotacao(Anotacao anotacao){
        this.anotacao = anotacao;
    }
}
