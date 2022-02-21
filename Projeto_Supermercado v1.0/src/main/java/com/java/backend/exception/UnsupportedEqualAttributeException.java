package com.java.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedEqualAttributeException extends RuntimeException{
    public UnsupportedEqualAttributeException(String exception){ super(exception); }
}
