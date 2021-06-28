package br.com.zupacademy.fabiano.casadocodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String sobrenome;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String documento;
    @NotNull
    @NotEmpty
    private String endereco;
    @NotNull
    @NotEmpty
    private String complemento;
    @NotNull
    @NotEmpty
    private String cidade;
    @NotNull
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @NotEmpty
    private String cep;

    public Cliente() {
    }

    public Cliente(@NotNull @NotEmpty @Email String email,
                   @NotNull @NotEmpty String nome,
                   @NotNull @NotEmpty String sobrenome,
                   @NotNull @NotEmpty String documento,
                   @NotNull @NotEmpty String endereco, String complemento,
                   @NotNull @NotEmpty String cidade,
                   @NotNull  Pais pais,
                   Estado estado,
                   @NotNull @NotEmpty String telefone,
                   @NotNull @NotEmpty String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}

