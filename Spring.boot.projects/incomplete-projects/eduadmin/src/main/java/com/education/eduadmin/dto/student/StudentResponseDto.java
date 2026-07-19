package com.education.eduadmin.dto.student;

import com.education.eduadmin.dto.address.AddressResponseDto;
import com.education.eduadmin.dto.guardian.GuardianResponseDto;
import com.education.eduadmin.entity.Gender;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentResponseDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private LocalDate dateOfBirth;
    private Gender gender;

    private AddressResponseDto addressResponseDTo;

    private List<GuardianResponseDto> guardianResponseDto = new ArrayList<>();

}
