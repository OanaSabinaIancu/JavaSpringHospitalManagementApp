package com.example.demojdbc.exceptions;

public class SalonNotFoundException extends RuntimeException{
    public SalonNotFoundException(String message) {
        super(message);
    }
}