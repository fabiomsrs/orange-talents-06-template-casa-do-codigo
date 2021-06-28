package br.com.zupacademy.fabiano.casadocodigo.validator;

import br.com.zupacademy.fabiano.casadocodigo.dto.ClienteRegisterDto;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Estado;
import br.com.zupacademy.fabiano.casadocodigo.modelo.Pais;
import br.com.zupacademy.fabiano.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.fabiano.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PaisEstadoValidator implements ConstraintValidator<PaisEstado, ClienteRegisterDto> {
    @Autowired
    PaisRepository paisRepository;
    @Autowired
    EstadoRepository estadoRepository ;

    private String message;

    @Override
    public void initialize(PaisEstado constraintAnnotation) {
        this.message = constraintAnnotation.message();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /*
    * Checa se o país possui estado, e caso possua, o estado passa a ser obrigatório
    * */
    @Override
    public boolean isValid(ClienteRegisterDto dto, ConstraintValidatorContext context) {
        Long estadoId = dto.getEstado();
        Long paisId = dto.getPais();
        if(!estadoRepository.findByPais_Id(paisId).isEmpty()){
            if (estadoId != null && estadoRepository.findById(estadoId).get().pertence(paisId)){
                return true;
            }
            context.buildConstraintViolationWithTemplate("Obrigatorio ter um estado pertecente ao País de Id = " + paisId.toString())
            .addConstraintViolation();
            return false;
        }
        return true;
    }
}
