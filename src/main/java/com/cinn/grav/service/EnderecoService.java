package com.cinn.grav.service;

import com.cinn.grav.entidades.Endereco;
import com.cinn.grav.repositorios.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco altera(String rua, String numero, String bairro, String complemento, String cidade, String estado){
        Endereco endereco = new Endereco(rua, Integer.parseInt(numero), bairro, complemento, cidade, estado);
        enderecoRepository.save(endereco);

        return endereco;
    }

    public Endereco adicionaEndereco(String rua, String numero, String bairro, String complemento, String cidade, String estado){
        Endereco endereco = null;
        if(rua != null){
            endereco = new Endereco(rua, Integer.parseInt(numero), bairro, complemento, cidade, estado);
            enderecoRepository.save(endereco);
        }

        return endereco;
    }
}
