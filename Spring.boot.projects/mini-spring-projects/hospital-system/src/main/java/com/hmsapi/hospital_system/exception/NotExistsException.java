package com.hmsapi.hospital_system.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NotExistsException extends RuntimeException {
    public NotExistsException(String message) {
        super(message);
    }
}
