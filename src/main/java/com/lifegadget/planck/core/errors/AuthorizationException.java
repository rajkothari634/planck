package com.lifegadget.planck.core.errors;

import org.springframework.http.HttpStatus;

public class AuthorizationException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private static final HttpStatus httpStatus = HttpStatus.FORBIDDEN;
    public AuthorizationException(String message){
        super(message);
    }
}
