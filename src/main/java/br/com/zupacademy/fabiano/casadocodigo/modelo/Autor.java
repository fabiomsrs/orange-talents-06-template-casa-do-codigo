package br.com.zupacademy.fabiano.casadocodigo.modelo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Autor(){
    }
    public Autor(@NotNull @NotEmpty String nome,
                 @NotNull @NotEmpty @Email(message = "E-mail inválido!") String email,
                 @NotNull @NotEmpty @Length(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
