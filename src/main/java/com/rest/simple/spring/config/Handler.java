package com.rest.simple.spring.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Handler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        StackTraceElement lastStackTraceElement = e.getStackTrace()[0];
        log.error("Catch not MVC exception \"{}\" from \"{}:{}\" with message: \"{}\"",
                e.getClass().getSimpleName(),
                lastStackTraceElement.getClassName(),
                lastStackTraceElement.getLineNumber(),
                e.getMessage(),
                e
        );
    }
}
