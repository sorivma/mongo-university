package com.example.mongouniversity.advice;

import com.example.mongouniversity.exception.ClientErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ClientErrorException.NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Response> handleNoEntityException(RuntimeException ex) {
        return new ResponseEntity<>(new Response(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private record Response(String message){}
}
