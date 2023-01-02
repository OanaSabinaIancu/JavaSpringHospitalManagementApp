package com.example.demojdbc.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class NurseExceptionHandler {

    @ExceptionHandler({NurseNotFoundException.class})
    public ResponseEntity<?> handleNurseNotFound(NurseNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List<String>> handleValid(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest()
                .body(e.getBindingResult().getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
    }
}
