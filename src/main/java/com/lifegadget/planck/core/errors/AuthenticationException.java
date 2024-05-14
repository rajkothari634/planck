package com.lifegadget.planck.core.errors;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private static final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
    public AuthenticationException(String message){
        super(message);
    }
}
