package com.nrifintech.training.secureapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String token;
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;
    @Column(nullable = false)
    private Instant expiry;
}
