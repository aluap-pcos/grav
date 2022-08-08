package com.cinn.grav.utils.form;

import com.cinn.grav.entidades.Anotacao;
import com.cinn.grav.entidades.Sintoma;
import com.cinn.grav.entidades.SintomaGestante;
import com.cinn.grav.utils.Datautils;

public class SintomaForm {
    private String sintomaId;
    private String intensidade;
    private String dataSintoma;
    private String anotacaoId;

    public SintomaForm(String sintomaId, String intensidade, String dataSintoma, String anotacaoId) {
        this.sintomaId = sintomaId;
        this.intensidade = intensidade;
        this.dataSintoma = dataSintoma;
        this.anotacaoId = anotacaoId;
    }

    public SintomaForm() {
    }

    public String getSintomaId() {
        return sintomaId;
    }

    public String getIntensidade() {
        return intensidade;
    }

    public String getDataSintoma() {
        return dataSintoma;
    }

    public String getAnotacaoId() {
        return anotacaoId;
    }

    public SintomaGestante convert(Sintoma sintoma, Anotacao anotacao){
        return new SintomaGestante(sintoma, Integer.parseInt(intensidade), Datautils.convertDateTime(dataSintoma), anotacao);
    }

    public SintomaGestante convertSemAnotacao(Sintoma sintoma){
        return new SintomaGestante(sintoma, Integer.parseInt(intensidade), Datautils.convertDateTime(dataSintoma), null);
    }
}
