package com.nrifintech.training.secureapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1/protected")
public class ProtectedController {
    @GetMapping(path = "/test")
    protected ResponseEntity<String> test() {
        return ResponseEntity.ok("Test Successfully completed.");
    }
}
