package com.cinn.grav.controller;

import com.cinn.grav.entidades.Exame;
import com.cinn.grav.repositorios.ConsultaRepository;
import com.cinn.grav.repositorios.EnderecoRepository;
import com.cinn.grav.repositorios.ExameRepository;
import com.cinn.grav.repositorios.TipoExameRepository;
import com.cinn.grav.service.ExameService;
import com.cinn.grav.utils.dto.ExameDTO;
import com.cinn.grav.utils.dto.ExameListDTO;
import com.cinn.grav.utils.exceptions.ItemBuscadoNaoExisteException;
import com.cinn.grav.utils.form.EditExameForm;
import com.cinn.grav.utils.form.ExameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exames")
public class ExameController {
    @Autowired
    private ExameRepository exameRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private TipoExameRepository tipoExameRepository;
    @Autowired
    private ExameService exameService;

    @GetMapping
    public List<ExameListDTO> listar(@RequestParam("inicio") String inicio, @RequestParam("fim") String fim){
        List<Exame> exames = exameService.listarPorPeriodo(inicio, fim);
        return ExameListDTO.convert(exames);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExameDTO> exameById(@PathVariable Integer id){
        try {
            Exame exame = exameService.buscaPorId(id);
            return ResponseEntity.ok(new ExameDTO(exame));
        } catch (ItemBuscadoNaoExisteException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ExameDTO> cadastrar(@RequestBody @Valid ExameForm exameForm, UriComponentsBuilder builder){
        Exame exame = exameForm.converter(consultaRepository, tipoExameRepository);
        exameRepository.save(exame);

        URI uri = builder.path("exames/{id}").buildAndExpand(exame.getId()).toUri();
        return ResponseEntity.created(uri).body(new ExameDTO(exame));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ExameDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid EditExameForm exameForm){
        Optional<Exame> exameOptional = exameRepository.findById(id);
        if(exameOptional.isPresent()){
            Exame exame = exameForm.atualizar(exameOptional.get());
            return ResponseEntity.ok(new ExameDTO(exame));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        Optional<Exame> exameOptional = exameRepository.findById(id);
        if(exameOptional.isPresent()){
            exameRepository.deleteById(id);
            return  ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
