package br.com.zupacademy.fabiano.casadocodigo.validator;

import br.com.zupacademy.fabiano.casadocodigo.dto.EstadoRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoDuplicadoValidator implements ConstraintValidator<EstadoDuplicado, EstadoRegisterDto> {
    @Autowired
    private EstadoRepository repository;

    @Override
    public void initialize(EstadoDuplicado constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EstadoRegisterDto dto, ConstraintValidatorContext context) {
        return repository.findByNomeAndPais_Id(dto.getNome(), dto.getPais()).isEmpty();
    }
}
