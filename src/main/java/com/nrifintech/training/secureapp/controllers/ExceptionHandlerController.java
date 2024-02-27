package com.nrifintech.training.secureapp.controllers;

import com.nrifintech.training.secureapp.dtos.ErrorDTO;
import com.nrifintech.training.secureapp.exceptions.InvalidCredentialsException;
import com.nrifintech.training.secureapp.exceptions.InvalidRefreshTokenException;
import com.nrifintech.training.secureapp.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Controller
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = InvalidCredentialsException.class)
    protected ResponseEntity<ErrorDTO> handleInvalidCredentialsException() {
        return new ResponseEntity<>(
                ErrorDTO
                        .builder()
                        .message("Invalid Credentials")
                        .timestamp(new Date())
                        .build(),
                HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(value = UserNotFoundException.class)
    protected ResponseEntity<ErrorDTO> handleUserNotFoundException() {
        return new ResponseEntity<>(
                ErrorDTO
                        .builder()
                        .message("User not found")
                        .timestamp(new Date())
                        .build(),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = InvalidRefreshTokenException.class)
    protected ResponseEntity<ErrorDTO> handleInvalidRefreshTokenException() {
        return new ResponseEntity<>(
                ErrorDTO
                        .builder()
                        .message("Invalid Refresh Token")
                        .timestamp(new Date())
                        .build(),
                HttpStatus.UNAUTHORIZED);
    }
}
