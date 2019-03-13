package com.stackroute.userservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> defaultHandler(Exception e){
        return new ResponseEntity<>("This is an exception handled by GlobalHandler: "+e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}