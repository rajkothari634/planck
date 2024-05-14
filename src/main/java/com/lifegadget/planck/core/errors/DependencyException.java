package com.lifegadget.planck.core.errors;

import org.springframework.http.HttpStatus;

public class DependencyException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private static final HttpStatus httpStatus = HttpStatus.FAILED_DEPENDENCY;
    public DependencyException(String message){
        super(message);
    }
}
