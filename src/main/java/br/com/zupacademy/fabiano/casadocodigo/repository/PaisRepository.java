package br.com.zupacademy.fabiano.casadocodigo.repository;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
