package com.lifegadget.planck.core.errors;

import org.springframework.http.HttpStatus;

public class ValidationException extends  RuntimeException{
    private static final long serialVersionUID = 1L;
    private static final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    public ValidationException(String message){
        super(message);
    }
}
