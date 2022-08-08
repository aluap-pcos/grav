package com.cinn.grav.entidades;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exame")
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "tipo_exame", referencedColumnName = "id")
    private TipoExame tipoExame;
    @OneToOne
    @JoinColumn(name = "endereco", referencedColumnName = "id")
    private Endereco endereco;
    private LocalDateTime dataExame;
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id")
    private Consulta consulta;

    private boolean realizado;

    public Exame(Integer id, TipoExame tipoExame, Endereco endereco, LocalDateTime dataExame, boolean realizado) {
        this.id = id;
        this.tipoExame = tipoExame;
        this.endereco = endereco;
        this.dataExame = dataExame;
        this.realizado = realizado;
    }

    public Exame(TipoExame tipoExame, Endereco endereco, LocalDateTime dataExame, Consulta consulta, boolean realizado) {
        this.tipoExame = tipoExame;
        this.endereco = endereco;
        this.dataExame = dataExame;
        this.consulta = consulta;
        this.realizado = realizado;
    }

    public Exame() {
    }

    public String getNomeExame(){
        return this.tipoExame.getNomeExame();
    }

    public LocalDateTime getDataExame() {
        return dataExame;
    }

    public boolean isRealizada(){
        return this.realizado;
    }

    public Integer getId() {
        return this.id;
    }

    public String getPreparo() {
        return this.tipoExame.getPreparo();
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public Integer getIdConsulta() {
        return this.consulta.getId();
    }

    public void alteraDataExame(LocalDateTime novaData){
        this.dataExame = novaData;
    }

    public void alteraEndereco(Endereco novoEndereco){
        this.endereco = novoEndereco;
    }
}
