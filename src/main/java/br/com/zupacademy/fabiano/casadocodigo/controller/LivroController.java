package br.com.zupacademy.fabiano.casadocodigo.controller;

import br.com.zupacademy.fabiano.casadocodigo.dto.CategoriaRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.dto.LivroRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Livro;
import br.com.zupacademy.fabiano.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody @Valid LivroRegisterDto dto) {
        Livro livro = dto.converter(autorRepository, categoriaRepository);
        repository.save(livro);
        return ResponseEntity.ok(livro);
    }
}
