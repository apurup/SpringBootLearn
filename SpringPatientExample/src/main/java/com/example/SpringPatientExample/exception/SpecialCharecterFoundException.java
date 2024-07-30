package com.example.SpringPatientExample.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class SpecialCharecterFoundException extends Exception{
    public SpecialCharecterFoundException(String message) {
        super(message);
    }
}
