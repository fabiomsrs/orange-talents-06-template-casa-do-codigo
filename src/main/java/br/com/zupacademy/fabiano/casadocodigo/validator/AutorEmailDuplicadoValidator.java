package br.com.zupacademy.fabiano.casadocodigo.validator;

import br.com.zupacademy.fabiano.casadocodigo.dto.AutorRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Autor;
import br.com.zupacademy.fabiano.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class AutorEmailDuplicadoValidator implements
        ConstraintValidator<AutorEmailDuplicado, AutorRegisterDto> {

    @Autowired
    AutorRepository repository;

    @Override
    public void initialize(AutorEmailDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AutorRegisterDto autor, ConstraintValidatorContext context) {
        List<Autor> listaAutor = this.repository.findByEmail(autor.getEmail());
        return listaAutor.isEmpty();
    }
}
