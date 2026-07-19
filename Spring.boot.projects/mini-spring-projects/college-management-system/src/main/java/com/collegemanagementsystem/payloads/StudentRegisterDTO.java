package com.collegemanagementsystem.payloads;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRegisterDTO {

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name cannot exceed 25 characters") // Add max length
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name cannot exceed 25 characters") // Add max length
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address") // Ensures valid email format
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other") // Restrict valid values
    private String gender; // Best practice: use an Enum for fixed categories like gender

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth must be in the past") // Ensures DOB is not in the future
    private LocalDate dateOfBirth;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 100, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    @CreatedDate
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;


}
