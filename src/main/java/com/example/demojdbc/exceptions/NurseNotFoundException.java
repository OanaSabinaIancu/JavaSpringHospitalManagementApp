package com.example.demojdbc.exceptions;

public class NurseNotFoundException extends RuntimeException{
    public NurseNotFoundException(String message) {
        super(message);
    }
}
