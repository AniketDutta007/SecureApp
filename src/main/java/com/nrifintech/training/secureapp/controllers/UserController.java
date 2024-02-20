package com.nrifintech.training.secureapp.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RolesAllowed("USER")
@RequestMapping(path = "/api/v1/user")
public class UserController {
    @GetMapping(path = "/test")
    protected ResponseEntity<String> test() {
        return ResponseEntity.ok("User Test Successful");
    }
}
