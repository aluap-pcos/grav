package com.cinn.grav.service;

import com.cinn.grav.entidades.Exame;
import com.cinn.grav.repositorios.ExameRepository;
import com.cinn.grav.utils.Datautils;
import com.cinn.grav.utils.exceptions.ItemBuscadoNaoExisteException;
import com.cinn.grav.utils.form.ExameForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ExameService {
    @Autowired
    private ExameRepository exameRepository;

    public List<Exame> listarPorPeriodo(String inicio, String fim){
        return exameRepository.listarExamesNumPeriodoDetempo(Datautils.convertDate(inicio), Datautils.convertDate(fim));
    }

    public Exame buscaPorId(Integer exameId) throws ItemBuscadoNaoExisteException {
        Optional<Exame> exame = exameRepository.findById(exameId);
        return exame.orElseThrow(() -> new ItemBuscadoNaoExisteException("Exame buscado não existe"));
    }
}
