package com.collegemanagementsystem.payloads;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int id;

    // Basic Details
    private String firstName;
    private String lastName;
    private String email;
    private String standard;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    private String confirmPassword;


    // Address
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;


    // System Info
    private boolean isActive;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;
}
