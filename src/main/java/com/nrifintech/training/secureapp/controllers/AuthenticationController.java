package com.nrifintech.training.secureapp.controllers;

import com.nrifintech.training.secureapp.dtos.AuthenticationResponseDTO;
import com.nrifintech.training.secureapp.dtos.SignInRequestDTO;
import com.nrifintech.training.secureapp.dtos.SignUpRequestDTO;
import com.nrifintech.training.secureapp.dtos.UserDTO;
import com.nrifintech.training.secureapp.exceptions.InvalidCredentialsException;
import com.nrifintech.training.secureapp.exceptions.InvalidRefreshTokenException;
import com.nrifintech.training.secureapp.exceptions.UserNotFoundException;
import com.nrifintech.training.secureapp.services.AuthenticationService;
import com.nrifintech.training.secureapp.services.RefreshTokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final RefreshTokenService refreshTokenService;
    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponseDTO> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO, HttpServletResponse response) throws UserNotFoundException {
        AuthenticationResponseDTO authenticationResponseDTO = authenticationService.register(signUpRequestDTO);
        response.addCookie(new Cookie("refresh_token", refreshTokenService.createRefreshToken(signUpRequestDTO.getEmail()).getToken()));
        return ResponseEntity.ok(authenticationResponseDTO);
    }
    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponseDTO> signIn(@RequestBody SignInRequestDTO signInRequestDTO) throws InvalidCredentialsException {
        return ResponseEntity.ok(authenticationService.authenticate(signInRequestDTO));
    }
    @GetMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponseDTO> refreshToken(@CookieValue("refresh_token") String refreshToken) throws UserNotFoundException, InvalidRefreshTokenException {
        UserDTO userDTO = refreshTokenService.validateRefreshToken(refreshToken);
        return ResponseEntity.ok(authenticationService.refreshToken(userDTO));
    }
    @GetMapping("/signout")
    public ResponseEntity<String> signOut(@CookieValue("refresh_token") String refreshToken) {
        refreshTokenService.deleteRefreshToken(refreshToken);
        return ResponseEntity.ok("Signed out successfully");
    }
}
