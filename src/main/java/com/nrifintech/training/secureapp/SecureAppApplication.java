package com.nrifintech.training.secureapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecureAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecureAppApplication.class, args);
    }

}
