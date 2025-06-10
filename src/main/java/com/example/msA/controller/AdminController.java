package com.example.msA.controller;

import com.example.msA.dto.LoginRequest;
import com.example.msA.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        System.out.println("Admin endpoint accessed");
        return null;
    }
}