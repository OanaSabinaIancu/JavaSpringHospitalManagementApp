package com.example.demojdbc.exceptions;

public class PacientNotFoundException extends RuntimeException{
    public PacientNotFoundException(String message) {
        super(message);
    }
}
