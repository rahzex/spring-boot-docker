package com.stackroute.playerservice.exceptions;

public class PlayerAlreadyExitsException extends Exception {

    private String message;
    public PlayerAlreadyExitsException(){}

    public PlayerAlreadyExitsException(String message) {
        super(message);
        this.message = message;
    }

}
