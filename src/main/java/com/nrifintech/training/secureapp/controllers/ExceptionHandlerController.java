package com.nrifintech.training.secureapp.controllers;

import com.nrifintech.training.secureapp.dtos.ErrorDTO;
import com.nrifintech.training.secureapp.exceptions.InvalidCredentialsException;
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
}
