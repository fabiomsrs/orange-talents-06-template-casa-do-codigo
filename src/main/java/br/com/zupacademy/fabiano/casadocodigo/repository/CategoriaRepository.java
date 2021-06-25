package br.com.zupacademy.fabiano.casadocodigo.repository;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
