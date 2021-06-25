package br.com.zupacademy.fabiano.casadocodigo.controller;

import br.com.zupacademy.fabiano.casadocodigo.dto.EstadoRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Estado;
import br.com.zupacademy.fabiano.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    EstadoRepository repository;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<Estado> cadastrar(@RequestBody @Valid EstadoRegisterDto dto) {
        Estado estado = dto.converter(paisRepository);
        repository.save(estado);
        return ResponseEntity.ok(estado);
    }
}
