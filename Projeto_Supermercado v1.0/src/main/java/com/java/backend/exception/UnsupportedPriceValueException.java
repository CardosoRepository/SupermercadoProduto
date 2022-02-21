package com.java.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedPriceValueException extends RuntimeException {
    public UnsupportedPriceValueException(String exception){ super(exception); }
}
