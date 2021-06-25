package br.com.zupacademy.fabiano.casadocodigo.controller;

import br.com.zupacademy.fabiano.casadocodigo.dto.PaisRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Pais;
import br.com.zupacademy.fabiano.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    PaisRepository repository;

    @PostMapping
    public ResponseEntity<Pais> cadastrar(@RequestBody @Valid PaisRegisterDto dto) {
        Pais pais = dto.converter();
        repository.save(pais);
        return ResponseEntity.ok(pais);
    }
}
