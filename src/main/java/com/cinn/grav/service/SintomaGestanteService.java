package com.cinn.grav.service;

import com.cinn.grav.entidades.Anotacao;
import com.cinn.grav.entidades.Sintoma;
import com.cinn.grav.entidades.SintomaGestante;
import com.cinn.grav.repositorios.AnotacaoRepository;
import com.cinn.grav.repositorios.SintomaRepository;
import com.cinn.grav.utils.Datautils;
import com.cinn.grav.utils.form.SintomaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaGestanteService {
    @Autowired
    private SintomaRepository sintomaRepository;

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    public List<SintomaGestante> coverteSintomaFormParaSintomaGestanteList(List<SintomaForm> forms){
        List<SintomaGestante> sintomas = new ArrayList<>();
        Anotacao anotacao = anotacaoRepository.findById(Integer.valueOf(forms.get(0).getAnotacaoId())).get();

        for(SintomaForm form : forms){
            Sintoma sintoma = sintomaRepository.findById(Integer.valueOf(form.getSintomaId())).get();
            sintomas.add(new SintomaGestante(sintoma, Integer.parseInt(form.getIntensidade()), Datautils.convertDateTime(form.getDataSintoma()), anotacao));
        }

        return sintomas;
    }

}
