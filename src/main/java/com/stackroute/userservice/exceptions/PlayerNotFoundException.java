package com.stackroute.userservice.exceptions;

public class PlayerNotFoundException extends Exception {

    private String message;
    public PlayerNotFoundException(){}

    public PlayerNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
