package com.nrifintech.training.secureapp.services;

import com.nrifintech.training.secureapp.dtos.AuthenticationResponseDTO;
import com.nrifintech.training.secureapp.dtos.SignInRequestDTO;
import com.nrifintech.training.secureapp.dtos.SignUpRequestDTO;
import com.nrifintech.training.secureapp.models.Credentials;
import com.nrifintech.training.secureapp.models.Name;
import com.nrifintech.training.secureapp.models.User;
import com.nrifintech.training.secureapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponseDTO register(SignUpRequestDTO signUpRequestDTO) {
        User user = User
                .builder()
                .name(
                        Name
                                .builder()
                                .firstName(signUpRequestDTO.getFirstName())
                                .lastName(signUpRequestDTO.getLastName())
                                .build()
                )
                .credentials(
                        Credentials
                                .builder()
                                .email(signUpRequestDTO.getEmail())
                                .password(passwordEncoder.encode(signUpRequestDTO.getPassword()))
                                .build()
                )
                .role(signUpRequestDTO.getRole())
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return AuthenticationResponseDTO
                .builder()
                .token(token)
                .build();
    }
    public AuthenticationResponseDTO authenticate(SignInRequestDTO signInRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequestDTO.getEmail(),
                        signInRequestDTO.getPassword()
                )
        );
        User user = userRepository.findUserByEmail(signInRequestDTO.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user);
        return AuthenticationResponseDTO
                .builder()
                .token(token)
                .build();
    }
}
