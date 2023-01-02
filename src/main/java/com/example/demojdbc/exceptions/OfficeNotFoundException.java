package com.example.demojdbc.exceptions;

public class OfficeNotFoundException extends RuntimeException{
    public OfficeNotFoundException(String message) {
        super(message);
    }
}