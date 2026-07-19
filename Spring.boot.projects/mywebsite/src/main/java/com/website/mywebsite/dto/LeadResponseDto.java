package com.website.mywebsite.dto;
import lombok.Data;


@Data
public class LeadResponseDto {

    private Long id;
    private String email;
    private String companyName;
    private String phone;
    private String inquiry;
    private String message;
}
