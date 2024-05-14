package com.lifegadget.planck.core.errors;

import org.springframework.http.HttpStatus;

public class DatabaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private static final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    public DatabaseException(String message){
        super(message);
    }
}
