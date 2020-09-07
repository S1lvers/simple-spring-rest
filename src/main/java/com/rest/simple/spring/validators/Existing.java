package com.rest.simple.spring.validators;

import com.rest.simple.spring.services.BasicFacade;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({FIELD})
@Constraint(validatedBy = ExistingValidator.class)
public @interface Existing {

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Entity doesn't exist";

    Class<? extends BasicFacade> facadeClass();
}

