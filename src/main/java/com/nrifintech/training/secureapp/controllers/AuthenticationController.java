package com.nrifintech.training.secureapp.controllers;

import com.nrifintech.training.secureapp.dtos.AuthenticationResponseDTO;
import com.nrifintech.training.secureapp.dtos.SignInRequestDTO;
import com.nrifintech.training.secureapp.dtos.SignUpRequestDTO;
import com.nrifintech.training.secureapp.exceptions.InvalidCredentialsException;
import com.nrifintech.training.secureapp.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponseDTO> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        return ResponseEntity.ok(authenticationService.register(signUpRequestDTO));
    }
    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponseDTO> signIn(@RequestBody SignInRequestDTO signInRequestDTO) throws InvalidCredentialsException {
        return ResponseEntity.ok(authenticationService.authenticate(signInRequestDTO));
    }
}
