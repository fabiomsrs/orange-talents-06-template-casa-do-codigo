package br.com.zupacademy.fabiano.casadocodigo.modelo;

import br.com.zupacademy.fabiano.casadocodigo.repository.EstadoRepository;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String nome;

    public Pais() {
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean temEstados(EstadoRepository estadoRepository) {
        return !estadoRepository.findByPais_Id(this.id).isEmpty();
    }
}
