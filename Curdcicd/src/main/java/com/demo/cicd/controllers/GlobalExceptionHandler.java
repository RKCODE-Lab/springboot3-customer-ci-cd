package com.demo.cicd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpServletRequest httpServletRequest) {
        System.out.println("No handler found exception");
        //ErrorResponse error = new ErrorResponse("An error occurred: " + ex.getMessage());
        ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, "An error occurred: ").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(ErrorResponse.builder(ex, HttpStatus.NOT_FOUND, "An error occurred: ").build());
    }
}

