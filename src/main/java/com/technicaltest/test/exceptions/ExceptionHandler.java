package com.technicaltest.test.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exceptions.class })
    protected ResponseEntity<Object> handleConflict(
            Exceptions ex, WebRequest request) {
        Message message = new Message(ex.getMessage());
        return handleExceptionInternal(ex, message,
                new HttpHeaders(), ex.getHttpStatus(), request);

    }
    
}
