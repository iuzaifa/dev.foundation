package com.example.security_example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Welcome! You are successfully authenticated.";
    }

    @GetMapping("/api/public")
    public String publicController() {
        return "Public API successfully authenticated.";
    }


    @GetMapping("/api/admin")
    public String adminController() {
        return "Admin API successfully authenticated.";
    }


}