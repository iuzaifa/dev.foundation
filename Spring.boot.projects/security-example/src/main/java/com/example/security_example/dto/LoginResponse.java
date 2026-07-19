package com.example.security_example.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class LoginResponse {

    private String email;
    private String jwt;

}
