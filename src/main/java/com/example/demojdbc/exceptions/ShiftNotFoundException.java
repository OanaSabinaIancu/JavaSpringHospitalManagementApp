package com.example.demojdbc.exceptions;

public class ShiftNotFoundException extends RuntimeException{
    public ShiftNotFoundException(String message) {
        super(message);
    }
}
