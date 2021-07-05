package br.com.zupacademy.fabiano.casadocodigo.dto;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Categoria;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Cliente;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Estado;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Pais;
import br.com.zupacademy.fabiano.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.fabiano.casadocodigo.validator.ChecaExistencia;
import br.com.zupacademy.fabiano.casadocodigo.validator.PaisEstado;
import br.com.zupacademy.fabiano.casadocodigo.validator.ValorUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@PaisEstado()
public class ClienteRegisterDto {
    @NotNull
    @NotEmpty
    @ValorUnico(instanceClass = Cliente.class, field = "email")
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    private String sobrenome;
    @NotNull
    @NotEmpty
    @ValorUnico(instanceClass = Cliente.class, field = "documento")
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
    @ChecaExistencia(identityField = "id", instanceClass = Pais.class)
    private Long pais;
    @ChecaExistencia(identityField = "id", instanceClass = Estado.class)
    private Long estado;
    @NotNull
    @NotEmpty
    private String telefone;
    @NotNull
    @NotEmpty
    private String cep;

    public ClienteRegisterDto() {
    }

    public ClienteRegisterDto( @NotNull @NotEmpty @Email String email,
                   @NotNull @NotEmpty String nome,
                   @NotNull @NotEmpty String sobrenome,
                   @NotNull @NotEmpty String documento,
                   @NotNull @NotEmpty String endereco, String complemento,
                   @NotNull @NotEmpty String cidade,
                   @NotNull Long pais,
                   Long estado,
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

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Optional<Pais> pais = paisRepository.findById(this.pais);
        Estado estadoInstance = null;
        if(this.estado != null){
            estadoInstance = estadoRepository.findById(this.estado).get();
        }
        return new Cliente(this.email,
                this.nome,
                this.sobrenome,
                this.documento,
                this.endereco,
                this.complemento,
                this.cidade,
                pais.get(),
                estadoInstance,
                this.telefone,
                this.cep);
    }
}
