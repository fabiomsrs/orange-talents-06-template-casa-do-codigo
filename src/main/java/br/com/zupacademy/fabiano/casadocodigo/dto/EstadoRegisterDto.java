package br.com.zupacademy.fabiano.casadocodigo.dto;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Estado;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Pais;
import br.com.zupacademy.fabiano.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.fabiano.casadocodigo.validator.EstadoDuplicado;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@EstadoDuplicado
public class EstadoRegisterDto {
    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private Long pais;

    public EstadoRegisterDto() {
    }

    public EstadoRegisterDto(@NotNull @NotEmpty String nome,
                             @NotNull Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }

    public Estado converter(PaisRepository repository) {
        Optional<Pais> pais = repository.findById(this.pais);
        return new Estado(this.nome, pais.get());
    }
}
