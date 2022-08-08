package com.cinn.grav.service;

import com.cinn.grav.entidades.Consulta;
import com.cinn.grav.repositorios.ConsultaRepository;
import com.cinn.grav.utils.dto.ConsultaDTO;
import com.cinn.grav.utils.exceptions.ConsultaNaoExisteException;
import com.cinn.grav.utils.form.ConsultaForm;
import com.cinn.grav.utils.form.EditConsultaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> listarPorPeriodo(LocalDate inicio, LocalDate fim, Integer gestanteId){
        return consultaRepository.findByDataConsultaBetweenAndGestanteId(inicio, fim, gestanteId);
    }

    public Consulta consultaById(Integer consultaId) throws ConsultaNaoExisteException {
        Optional<Consulta> consulta = consultaRepository.findById(consultaId);
        if(consulta.isEmpty()){
            throw new ConsultaNaoExisteException();
        }
        return consulta.get();
    }

    public Consulta cadastrar(ConsultaForm form){
        Consulta consulta = form.converter();
        consultaRepository.save(consulta);
        return consulta;
    }

    public Consulta atualizar(Integer consultaId, EditConsultaForm form) throws ConsultaNaoExisteException {
        Optional<Consulta> optionalConsulta = consultaRepository.findById(consultaId);
        if(optionalConsulta.isEmpty()){
            throw new ConsultaNaoExisteException();
        }

        Consulta consulta = form.atualizar(optionalConsulta.get());
        consultaRepository.save(consulta);
        return consulta;
    }

    public void deletar(Integer consultaId) throws ConsultaNaoExisteException {
        Optional<Consulta> consulta = consultaRepository.findById(consultaId);
        if(consulta.isEmpty()){
            throw new ConsultaNaoExisteException();
        }
        consultaRepository.deleteById(consultaId);
    }

}
