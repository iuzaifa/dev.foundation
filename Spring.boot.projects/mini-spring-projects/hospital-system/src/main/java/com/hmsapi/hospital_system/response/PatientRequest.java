package com.hmsapi.hospital_system.response;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequest {




    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 25 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private String name;

    @NotBlank(message = "Father Name must not be blank")
    @Size(min = 2, max = 20, message = "Father Name must be between 2 and 25 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Father Name must contain only letters and spaces")
    private String fatherName;

    @NotBlank(message = "Mother Name must not be blank")
    @Size(min = 2, max = 20, message = "Mother Name must be between 2 and 25 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Mother Name must contain only letters and spaces")
    private String motherName;

    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be at least 0")
    @Max(value = 120, message = "Age must be less than or equal to 120")
    private int age;

    @NotEmpty(message = "Phone number must not be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact Number number must be exactly 10 digits")
    private String contactNumber;

    @NotBlank(message = "Address must not be blank")
    @Size(min = 5, max = 255, message = "Address must be between 5 and 255 characters")
    private String address;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;
    private String bloodGroup;

    @NotEmpty(message = "Phone number must not be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Emergency Contact number must be exactly 10 digits")
    private String emergencyContact;

    @NotNull(message = "Admitted status must be specified")
    private boolean admitted;
}
