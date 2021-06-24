package br.com.zupacademy.fabiano.casadocodigo.dto;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorRegisterDto {
    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    @Email(message = "E-mail inválido!")
    private String email;

    @NotNull
    @NotEmpty
    @Length(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
