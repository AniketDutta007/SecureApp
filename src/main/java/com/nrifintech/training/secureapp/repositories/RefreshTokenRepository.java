package com.nrifintech.training.secureapp.repositories;

import com.mysql.cj.MysqlConnection;
import com.nrifintech.training.secureapp.models.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByToken(String token);
}
