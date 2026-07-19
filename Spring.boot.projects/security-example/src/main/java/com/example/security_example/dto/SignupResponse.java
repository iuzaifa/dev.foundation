package com.example.security_example.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignupResponse {

    private Long userID;
    private String email;
    private String password;
    private String address;


}
