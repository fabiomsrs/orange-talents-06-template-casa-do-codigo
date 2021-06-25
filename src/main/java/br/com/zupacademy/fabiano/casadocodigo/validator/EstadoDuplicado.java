package br.com.zupacademy.fabiano.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EstadoDuplicadoValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoDuplicado {
    String message() default "Estado já cadastrado nesse país";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
