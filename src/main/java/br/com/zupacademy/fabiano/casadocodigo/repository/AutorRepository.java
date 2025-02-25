package br.com.zupacademy.fabiano.casadocodigo.repository;

import br.com.zupacademy.fabiano.casadocodigo.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByEmail(String email);
}
