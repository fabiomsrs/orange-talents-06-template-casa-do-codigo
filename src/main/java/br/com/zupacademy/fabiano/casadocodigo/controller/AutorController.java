package br.com.zupacademy.fabiano.casadocodigo.controller;

import br.com.zupacademy.fabiano.casadocodigo.dto.AutorRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Autor;
import br.com.zupacademy.fabiano.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    AutorRepository repository;

    @PostMapping
    public ResponseEntity<Autor> cadastrar(@RequestBody @Valid AutorRegisterDto dto) {
        Autor autor = dto.converter();
        repository.save(autor);
        return ResponseEntity.ok(autor);
    }
}
