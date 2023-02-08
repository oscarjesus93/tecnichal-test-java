package com.technicaltest.test.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Exceptions extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public Exceptions(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
