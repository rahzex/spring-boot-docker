package com.stackroute.playerservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

/*
 * This class handles all the exceptions that will occur through out this project
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /* This method uses/handles the custom exception class PlayerAlreadyExistsException*/
    @ExceptionHandler(PlayerAlreadyExitsException.class)
    public ResponseEntity<String> playerExistsHandler(PlayerAlreadyExitsException e){
        return new ResponseEntity<>("GlobalExceptionHandler : PlayerAlreadyExists!\n" + e.getMessage(),HttpStatus.CONFLICT);
    }

    /* This method uses/handles the custom exception class PlayerNotFoundException*/
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<String> playerNotFoundHandler(PlayerNotFoundException e){
        return new ResponseEntity<>("GlobalExceptionHandler : PlayerNotFound!\n "+e.getMessage(),HttpStatus.CONFLICT);
    }
}