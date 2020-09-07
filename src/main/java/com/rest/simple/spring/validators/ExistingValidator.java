package com.rest.simple.spring.validators;

import com.rest.simple.spring.services.BasicFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Existing validator could be used with different entities, just need pass right Facade into validator and that's it
@Component
@RequiredArgsConstructor
public class ExistingValidator implements ConstraintValidator<Existing, Object>, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private BasicFacade facade;

    @Override
    public void initialize(Existing constraintAnnotation) {
        final Class<? extends BasicFacade> facadeClass = constraintAnnotation.facadeClass();
        facade = applicationContext.getBean(facadeClass);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return facade.existsById(value);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
