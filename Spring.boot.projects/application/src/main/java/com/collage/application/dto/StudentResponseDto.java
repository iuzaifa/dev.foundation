package com.collage.application.dto;

import lombok.Data;

@Data
public class StudentResponseDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

}
