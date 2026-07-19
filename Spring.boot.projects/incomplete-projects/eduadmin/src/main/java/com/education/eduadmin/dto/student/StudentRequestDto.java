package com.education.eduadmin.dto.student;

import com.education.eduadmin.dto.address.AddressRequestDto;
import com.education.eduadmin.dto.guardian.GuardianRequestDto;
import com.education.eduadmin.entity.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentRequestDto {


    @NotNull(message = "First Name is required")
    private String firstname;

    @NotNull(message = "Last Name is required")
    private String lastname;

    @NotNull(message = "Phone number is required")
    private String phone;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private LocalDate dateOfBirth;
    private Gender gender;

    private AddressRequestDto addressRequestDto;

    private List<GuardianRequestDto> guardianRequestDto = new ArrayList<>();




}
