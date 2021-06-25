package br.com.zupacademy.fabiano.casadocodigo.repository;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByNomeAndPais_Id(String nome, Long pais);
}
