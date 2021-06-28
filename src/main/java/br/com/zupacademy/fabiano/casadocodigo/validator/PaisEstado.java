package br.com.zupacademy.fabiano.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PaisEstadoValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PaisEstado {
    String message() default "Estado inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
