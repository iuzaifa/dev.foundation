package com.example.security_example.dto;

import lombok.Data;

@Data
public class SignupRequest {

    private String email;
    private String password;
    private String address;
}
