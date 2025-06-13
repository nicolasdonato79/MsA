package com.example.msA.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Este endpoint es público.";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Solo usuarios con rol ADMIN pueden ver esto.";
    }

    @GetMapping("/user")
    public String userEndpoint(Authentication authentication) {
        String username = authentication.getName();

        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return "Usuario autenticado: " + username + "\nRoles: " + String.join(", ", roles);
    }
}
