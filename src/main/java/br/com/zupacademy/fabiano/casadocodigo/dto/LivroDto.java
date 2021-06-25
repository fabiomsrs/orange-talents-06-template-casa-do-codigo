package br.com.zupacademy.fabiano.casadocodigo.dto;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {
    private Long id;
    private String titulo;

    public LivroDto (){
    }
    public LivroDto (Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<LivroDto> converter(List<Livro> livros) {
        return livros.stream().map(LivroDto::new).collect(Collectors.toList());
    }
}
