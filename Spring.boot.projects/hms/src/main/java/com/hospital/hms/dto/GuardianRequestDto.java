package com.hospital.hms.dto;

import com.hospital.hms.entity.Address;
import com.hospital.hms.entity.BloodGroup;
import com.hospital.hms.entity.Patient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class GuardianRequestDto {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
    private String name;

    private String relation; // e.g. Father, Mother, Spouse, etc.

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be 10 digits and start with 6-9")
    private String phone;

    private String email;
    private BloodGroup bloodGroup;
    private Address address;
    private List<Patient> patients;



}
