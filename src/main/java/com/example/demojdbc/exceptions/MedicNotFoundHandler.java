package com.example.demojdbc.exceptions;

public class MedicNotFoundHandler extends  RuntimeException{
    public MedicNotFoundHandler(String message) {
        super(message);
    }
}
