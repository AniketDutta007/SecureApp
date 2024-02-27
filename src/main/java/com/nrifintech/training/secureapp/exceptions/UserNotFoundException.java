package com.nrifintech.training.secureapp.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User not found");
    }
}
