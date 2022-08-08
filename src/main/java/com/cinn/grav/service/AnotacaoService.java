package com.cinn.grav.service;

import com.cinn.grav.entidades.Anotacao;
import com.cinn.grav.entidades.Consulta;
import com.cinn.grav.entidades.Sintoma;
import com.cinn.grav.entidades.SintomaGestante;
import com.cinn.grav.repositorios.AnotacaoRepository;
import com.cinn.grav.repositorios.ConsultaRepository;
import com.cinn.grav.repositorios.SintomaRepository;
import com.cinn.grav.utils.Datautils;
import com.cinn.grav.utils.exceptions.ItemBuscadoNaoExisteException;
import com.cinn.grav.utils.form.AnotacaoForm;
import com.cinn.grav.utils.form.EditAnotacaoForm;
import com.cinn.grav.utils.form.SintomaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnotacaoService {
    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private SintomaRepository sintomaRepository;

    @Autowired
    private SintomaGestanteService sintomaGestanteService;

    public Anotacao buscarAnotacaoPorConsultaId(Integer consultaId) throws ItemBuscadoNaoExisteException {
        Optional<Anotacao> optionalAnotacao = anotacaoRepository.buscaAnotacaoPorIdConsulta(consultaId);
        if(optionalAnotacao.isEmpty()){
            throw new ItemBuscadoNaoExisteException("Não existe anotação para a consulta " + consultaId);
        }
        return optionalAnotacao.get();
    }

    public Anotacao atualizarAnotacao(EditAnotacaoForm form, Integer anotacaoId) throws ItemBuscadoNaoExisteException {
        Optional<Anotacao> optionalAnotacao = anotacaoRepository.findById(anotacaoId);
        form.atualizar(optionalAnotacao.orElseThrow(() -> new ItemBuscadoNaoExisteException("A anotação que tenta atualizar não existe")));
        return optionalAnotacao.get();
    }

    public Anotacao ciarAnotacao(AnotacaoForm form) throws ItemBuscadoNaoExisteException {
        Anotacao anotacao = new Anotacao(new ArrayList<>(), form.getTexto());
        anotacaoRepository.save(anotacao);

        List<SintomaGestante> sintomas = converterListFormParaListSintoma(form.getSintomas(), anotacao);
        anotacao.setSintomas(sintomas);

        Optional<Consulta> consulta = consultaRepository.findById(form.getConsultaId());
        consulta.orElseThrow(() -> new ItemBuscadoNaoExisteException("A consulta na qual está tentando inserir uma anotação não existe")).adicionaAnotacao(anotacao);
        return anotacao;
    }

    public void deletar(Integer anotacaoId) throws ItemBuscadoNaoExisteException {
        Optional<Anotacao> anotacao = anotacaoRepository.findById(anotacaoId);
        anotacaoRepository.delete(anotacao.orElseThrow(() -> new ItemBuscadoNaoExisteException("A anotação que está tentando deletar não existe")));
    }

    public List<SintomaGestante> converterListFormParaListSintoma(List<SintomaForm> form, Anotacao anotacao){
        List<SintomaGestante> sintomas = new ArrayList<>();
        Sintoma tipoSintoma = null;

        for(SintomaForm s : form){
            tipoSintoma = sintomaRepository.findById(Integer.parseInt(s.getSintomaId())).get();
            sintomas.add(new SintomaGestante(tipoSintoma, Integer.parseInt(s.getIntensidade()), Datautils.convertDateTime(s.getDataSintoma()), anotacao));
        }


        return sintomas;
    }
}
