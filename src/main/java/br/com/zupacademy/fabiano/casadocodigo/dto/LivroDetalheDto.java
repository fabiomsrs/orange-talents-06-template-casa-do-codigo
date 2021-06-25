package br.com.zupacademy.fabiano.casadocodigo.dto;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Autor;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Livro;

import java.time.LocalDateTime;

public class LivroDetalheDto {
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numPagina;
    private String isbn;
    private LocalDateTime dataPublicacao;
    private Categoria categoria;
    private Autor autor;

    public  LivroDetalheDto(){
    }

    public LivroDetalheDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPagina = livro.getNumPagina();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumPagina() {
        return numPagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
