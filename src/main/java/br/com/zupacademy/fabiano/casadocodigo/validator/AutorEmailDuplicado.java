package br.com.zupacademy.fabiano.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AutorEmailDuplicadoValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AutorEmailDuplicado {
    String message() default "Email já cadastrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
