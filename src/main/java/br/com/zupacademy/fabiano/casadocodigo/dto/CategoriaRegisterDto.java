package br.com.zupacademy.fabiano.casadocodigo.dto;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.fabiano.casadocodigo.validator.ValorUnico;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaRegisterDto {
    @NotNull
    @NotEmpty
    @ValorUnico(instanceClass = Categoria.class, field = "nome")
    private String nome;

    public CategoriaRegisterDto() {
    }

    public CategoriaRegisterDto(@NotNull @NotEmpty String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
