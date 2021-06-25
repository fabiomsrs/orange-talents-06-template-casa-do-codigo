package br.com.zupacademy.fabiano.casadocodigo.dto;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Autor;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Livro;
import br.com.zupacademy.fabiano.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.fabiano.casadocodigo.validator.ChecaExistencia;
import br.com.zupacademy.fabiano.casadocodigo.validator.ValorUnico;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

public class LivroRegisterDto {
    @NotNull
    @NotEmpty
    @ValorUnico(instanceClass = Livro.class, field = "titulo")
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
    @ValorUnico(instanceClass = Livro.class, field = "isbn")
    private String isbn;
    @Future
    private LocalDateTime dataPublicacao;
    @NotNull
    @ChecaExistencia(identityField = "id", instanceClass = Categoria.class)
    private Long categoria;
    @NotNull
    @ChecaExistencia(identityField = "id", instanceClass = Autor.class)
    private Long autor;

    public LivroRegisterDto() {
    }

    public LivroRegisterDto(@NotNull @NotEmpty String titulo,
                 @NotNull @NotEmpty @Length(max = 500) String resumo,
                 String sumario,
                 @NotNull @Min(value=20) Double preco,
                 @NotNull @Min(value=100) Integer numPagina,
                 @NotNull @NotEmpty String isbn,
                 @Future LocalDateTime dataPublicacao,
                 @NotNull Long categoria,
                 @NotNull Long autor) {
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

    public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) throws ResponseStatusException {
        Optional<Autor> autor = autorRepository.findById(this.autor);
        Optional<Categoria> categoria = categoriaRepository.findById(this.categoria);
        return new Livro(this.titulo,
                this.resumo,
                this.sumario,
                this.preco,
                this.numPagina,
                this.isbn,
                this.dataPublicacao,
                categoria.get(),
                autor.get());
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(Integer numPagina) {
        this.numPagina = numPagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public Long getAutor() {
        return autor;
    }

    public void setAutor(Long autor) {
        this.autor = autor;
    }
}
