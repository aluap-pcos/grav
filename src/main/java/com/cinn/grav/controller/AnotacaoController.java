package com.cinn.grav.controller;

import com.cinn.grav.entidades.Anotacao;
import com.cinn.grav.repositorios.AnotacaoRepository;
import com.cinn.grav.repositorios.ConsultaRepository;
import com.cinn.grav.service.AnotacaoService;
import com.cinn.grav.utils.dto.AnotacaoDTO;
import com.cinn.grav.utils.dto.ExameDTO;
import com.cinn.grav.utils.exceptions.ItemBuscadoNaoExisteException;
import com.cinn.grav.utils.form.AnotacaoForm;
import com.cinn.grav.utils.form.EditAnotacaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/anotacao")
public class AnotacaoController {
    @Autowired
    private AnotacaoService anotacaoService;

    @GetMapping("/{consultaId}")
    public ResponseEntity<AnotacaoDTO> buscarPorIdConsulta(@PathVariable Integer consultaId){
        try {
            Anotacao anotacao = anotacaoService.buscarAnotacaoPorConsultaId(consultaId);
            return ResponseEntity.ok(new AnotacaoDTO(anotacao));
        } catch (ItemBuscadoNaoExisteException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AnotacaoDTO> cadastrar(@RequestBody @Valid AnotacaoForm anotacaoForm, UriComponentsBuilder builder){
        try {
            Anotacao anotacao = anotacaoService.ciarAnotacao(anotacaoForm);
            URI uri = builder.path("/anotacao/{id}").buildAndExpand(anotacao.getId()).toUri();
            return ResponseEntity.created(uri).body(new AnotacaoDTO(anotacao));

        } catch (ItemBuscadoNaoExisteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AnotacaoDTO> atualizar(@PathVariable Integer anotacaoId, @RequestBody EditAnotacaoForm anotacaoForm){
        try {
            Anotacao anotacao = anotacaoService.atualizarAnotacao(anotacaoForm, anotacaoId);
            return ResponseEntity.ok(new AnotacaoDTO(anotacao));
        } catch (ItemBuscadoNaoExisteException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Integer id){
        try {
            anotacaoService.deletar(id);
            return ResponseEntity.ok().build();
        } catch (ItemBuscadoNaoExisteException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
