package com.rest.simple.spring.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class clazz, String id) {
        super(String.format("Can't find entity [%s] with id [%s]", clazz.getSimpleName(), id));
    }
}
