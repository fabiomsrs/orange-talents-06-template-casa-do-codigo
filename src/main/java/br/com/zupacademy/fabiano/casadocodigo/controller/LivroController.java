package br.com.zupacademy.fabiano.casadocodigo.controller;

import br.com.zupacademy.fabiano.casadocodigo.dto.CategoriaRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.dto.LivroDetalheDto;
import br.com.zupacademy.fabiano.casadocodigo.dto.LivroDto;
import br.com.zupacademy.fabiano.casadocodigo.dto.LivroRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Livro;
import br.com.zupacademy.fabiano.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<LivroDto>> listar(){
        List<Livro> livros = repository.findAll();
        return ResponseEntity.ok(LivroDto.converter(livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalheDto> detalhar(@PathVariable Long id){
        Optional<Livro> livro = repository.findById(id);
        if(livro.isPresent()){
            return ResponseEntity.ok(new LivroDetalheDto(livro.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
