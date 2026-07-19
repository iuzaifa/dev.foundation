package com.hmsapi.hospital_system.response;

import com.hmsapi.hospital_system.model.DoctorStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DoctorRequest {


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

    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be at least 0")
    @Max(value = 120, message = "Age must be less than or equal to 120")
    private int age;

    @NotEmpty(message = "Phone number must not be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact Number number must be exactly 10 digits")
    private String contactNumber;

    @NotBlank(message = "Specialization must not be blank")
    @Size(min = 2, max = 100, message = "Specialization must be between 2 and 100 characters")
    private String specialization;

    @NotBlank(message = "Qualification must not be blank")
    @Size(min = 2, max = 100, message = "Qualification must be between 2 and 100 characters")
    private String qualification;


    @Min(value = 0, message = "Years of experience must be 0 or more")
    @Max(value = 70, message = "Years of experience must be less than or equal to 70")
    private int yearsOfExperience;

    @NotNull(message = "Joining date is required")
    @PastOrPresent(message = "Joining date cannot be in the future")
    private LocalDate joiningDate;


    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private DoctorStatus status;

    @NotNull(message = "Availability must be specified")
    private boolean available;
}
