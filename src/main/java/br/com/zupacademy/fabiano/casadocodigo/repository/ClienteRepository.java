package br.com.zupacademy.fabiano.casadocodigo.repository;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
