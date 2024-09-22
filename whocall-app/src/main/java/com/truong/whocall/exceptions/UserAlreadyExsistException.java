package com.truong.whocall.exceptions;

public class UserAlreadyExsistException extends Exception {
    private String message;
    public UserAlreadyExsistException(String username) {    
        this.message = "Username: " + username + " already exists!";
    }


    public String getMessage() {
        return this.message;
    }
}
