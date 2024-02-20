package com.nrifintech.training.secureapp.repositories;

import com.nrifintech.training.secureapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT user FROM User user WHERE user.credentials.email = :email")
    Optional<User> findUserByEmail(String email);
}
