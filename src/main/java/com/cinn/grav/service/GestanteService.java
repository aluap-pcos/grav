package com.cinn.grav.service;

import com.cinn.grav.entidades.UsuarioGestante;
import com.cinn.grav.repositorios.UsuarioGestanteRepository;
import com.cinn.grav.utils.Datautils;
import com.cinn.grav.utils.form.CadastroGestanteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestanteService {
    @Autowired
    private UsuarioGestanteRepository gestanteRepository;

    public UsuarioGestante criar(CadastroGestanteForm form){
        UsuarioGestante gestante = new UsuarioGestante(form.getNome(), form.getNomeBebe(), form.getEmail(), Datautils.convertDate(form.getDataUltimaMenstruacao()), form.getEmergenciaMedico(), form.getEmergenciaFamilia());
        gestanteRepository.save(gestante);
        return gestante;
    }
}
