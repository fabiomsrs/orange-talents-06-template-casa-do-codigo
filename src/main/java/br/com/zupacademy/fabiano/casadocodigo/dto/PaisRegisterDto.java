package br.com.zupacademy.fabiano.casadocodigo.dto;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Pais;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PaisRegisterDto {
    @NotNull
    @NotEmpty
    private String nome;

    public String getNome() {
        return nome;
    }

    public PaisRegisterDto() {
    }

    public PaisRegisterDto(@NotNull @NotEmpty String nome) {
        this.nome = nome;
    }

    public Pais converter() {
        return new Pais(this.nome);
    }
}
