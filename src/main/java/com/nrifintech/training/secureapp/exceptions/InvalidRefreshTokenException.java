package com.nrifintech.training.secureapp.exceptions;

public class InvalidRefreshTokenException extends Exception {
    public InvalidRefreshTokenException() {
        super("Invalid refresh token");
    }
}
