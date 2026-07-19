package com.hospital.hms.dto;

import com.hospital.hms.entity.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PatientRequestDto {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits and start with 6-9")
    private String phone;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Alternate number must be 10 digits and start with 6-9")
    private String alternateNumber;

    private String photoUrl; // Optional

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Size(max = 255, message = "Remark should not exceed 255 characters")
    private String remark;

    private BloodGroup bloodGroup; // Enum

    @NotNull(message = "Gender is required")
    private Gender gender; // Enum

    private MaritalStatus maritalStatus; // Enum

    private List<Guardian> guardians;
    private List<Address> addresses;
    private List<Allergy> allergies;
    private List<Disease> diseases;
    private List<Document> documents;
    private LocalDateTime createdAt;
}
