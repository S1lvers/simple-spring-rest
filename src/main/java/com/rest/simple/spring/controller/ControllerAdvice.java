package com.rest.simple.spring.controller;

import com.rest.simple.spring.model.response.ApiErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ApiErrorResponse handleException(Exception ex) {
        log.error("Error occurred = {}", ex.getMessage(), ex);
        return new ApiErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Pair<String, String>> handleValidationException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        final BindingResult bindingResult = ex.getBindingResult();
        final List<Pair<String, String>> errors = bindingResult.getAllErrors().stream()
                .map(ControllerAdvice::getErrorPair)
                .collect(Collectors.toList());

        log.debug("REST API validation failed for request = {}, method = {}. Body = {}. Faulted constraints = \n{}",
                request.getRequestURL(), request.getMethod(), bindingResult.getTarget(), errors);

        return errors;
    }

    private static Pair<String, String> getErrorPair(final ObjectError error) {
        return new ImmutablePair<>(error instanceof FieldError ? ((FieldError) error).getField() : error.getObjectName(), error.getDefaultMessage());
    }
}
