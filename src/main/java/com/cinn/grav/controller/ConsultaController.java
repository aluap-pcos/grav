package com.cinn.grav.controller;

import com.cinn.grav.entidades.Consulta;
import com.cinn.grav.repositorios.ConsultaRepository;
import com.cinn.grav.repositorios.EnderecoRepository;
import com.cinn.grav.service.ConsultaService;
import com.cinn.grav.utils.dto.ConsultaDTO;
import com.cinn.grav.utils.dto.ConsultaListDTO;
import com.cinn.grav.utils.exceptions.ConsultaNaoExisteException;
import com.cinn.grav.utils.form.ConsultaForm;
import com.cinn.grav.utils.form.EditConsultaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<ConsultaListDTO> listarPorPeriodo(@RequestParam(name = "inicio") LocalDate inicio, @RequestParam(name = "fim") LocalDate fim, @RequestParam Integer gestanteId){
        List<Consulta> consultas = consultaService.listarPorPeriodo(inicio, fim, gestanteId);
        return ConsultaListDTO.convert(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> consultaById(@PathVariable Integer id){
        try {
            Consulta consulta = consultaService.consultaById(id);
            return ResponseEntity.ok(new ConsultaDTO(consulta));
        } catch (ConsultaNaoExisteException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ConsultaDTO> cadastrar(@RequestBody @Valid ConsultaForm consultaForm, UriComponentsBuilder builder){
        Consulta consulta = consultaService.cadastrar(consultaForm);

        URI uri = builder.path("/consultas/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(uri).body(new ConsultaDTO(consulta));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ConsultaDTO> atualizar(@PathVariable Integer id, @RequestBody @Valid EditConsultaForm consultaForm){
        try {
            Consulta consulta = consultaService.atualizar(id, consultaForm);
            return ResponseEntity.ok(new ConsultaDTO(consulta));
        } catch (ConsultaNaoExisteException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Integer id){
        try {
            consultaService.deletar(id);
            return ResponseEntity.ok().build();
        } catch (ConsultaNaoExisteException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
