package com.nrifintech.training.secureapp.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RolesAllowed({"ADMIN", "MANAGER"})
@RequestMapping(path = "/api/v1/manager")
public class ManagerController {
    @GetMapping(path = "/test")
    @PreAuthorize("hasAnyAuthority('admin:read', 'manager:read')")
    protected ResponseEntity<String> test() {
        return ResponseEntity.ok("Manager Test Successful!");
    }
}
