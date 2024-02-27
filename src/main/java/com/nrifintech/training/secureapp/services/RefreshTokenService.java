package com.nrifintech.training.secureapp.services;

import com.nrifintech.training.secureapp.dtos.RefreshTokenDTO;
import com.nrifintech.training.secureapp.dtos.UserDTO;
import com.nrifintech.training.secureapp.exceptions.InvalidRefreshTokenException;
import com.nrifintech.training.secureapp.exceptions.UserNotFoundException;
import com.nrifintech.training.secureapp.mappers.RefreshTokenMapper;
import com.nrifintech.training.secureapp.mappers.UserMapper;
import com.nrifintech.training.secureapp.models.RefreshToken;
import com.nrifintech.training.secureapp.repositories.RefreshTokenRepository;
import com.nrifintech.training.secureapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final RefreshTokenMapper refreshTokenMapper;
    private final UserMapper userMapper;
    public RefreshTokenDTO createRefreshToken(String email) throws UserNotFoundException {
        RefreshToken refreshToken = RefreshToken.builder()
                .token(UUID.randomUUID().toString())
                .user(userRepository.findUserByEmail(email).orElseThrow(UserNotFoundException::new))
                .expiry(Instant.now().plusMillis(1000L *60*60*24*30))
                .build();
        refreshTokenRepository.save(refreshToken);
        return refreshTokenMapper.toDTO(refreshToken);
    }
    public UserDTO validateRefreshToken(String token) throws InvalidRefreshTokenException {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token).orElseThrow(InvalidRefreshTokenException::new);
        return userMapper.toDTO(refreshToken.getUser());
    }
    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
