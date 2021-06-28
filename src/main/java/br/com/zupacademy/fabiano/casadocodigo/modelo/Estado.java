package br.com.zupacademy.fabiano.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @ManyToOne()
    private Pais pais;

    public Estado() {
    }

    public Estado(@NotNull @NotEmpty String nome,
                  @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public boolean pertence(Long pais) {
        return this.pais.getId() == pais;
    }
}
