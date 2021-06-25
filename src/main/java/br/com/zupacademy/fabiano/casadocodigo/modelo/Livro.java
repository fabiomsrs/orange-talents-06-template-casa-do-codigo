package br.com.zupacademy.fabiano.casadocodigo.modelo;

import br.com.zupacademy.fabiano.casadocodigo.validator.ValorUnico;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String titulo;
    @NotNull
    @NotEmpty
    @Length(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(value=20)
    private Double preco;
    @NotNull
    @Min(value=100)
    private Integer numPagina;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String isbn;
    @Future
    private LocalDateTime dataPublicacao;
    @NotNull
    @ManyToOne()
    private Categoria categoria;
    @NotNull
    @ManyToOne()
    private Autor autor;

    public Livro() {
    }

    public Livro(@NotNull @NotEmpty String titulo,
                 @NotNull @NotEmpty @Length(max = 500) String resumo,
                 String sumario,
                 @NotNull @Min(value=20) Double preco,
                 @NotNull @Min(value=100) Integer numPagina,
                 @NotNull @NotEmpty String isbn,
                 @Future LocalDateTime dataPublicacao,
                 @NotNull Categoria categoria,
                 @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPagina = numPagina;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
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
