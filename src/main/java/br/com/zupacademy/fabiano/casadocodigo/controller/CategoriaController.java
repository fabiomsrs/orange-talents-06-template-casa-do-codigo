package br.com.zupacademy.fabiano.casadocodigo.controller;

import br.com.zupacademy.fabiano.casadocodigo.dto.CategoriaRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.fabiano.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaRepository repository;

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid CategoriaRegisterDto dto) {
        Categoria categoria = dto.converter();
        repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}
