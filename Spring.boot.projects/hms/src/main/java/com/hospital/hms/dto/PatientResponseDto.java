package com.hospital.hms.dto;

import com.hospital.hms.entity.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PatientResponseDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String alternateNumber;
    private String photoUrl;
    private LocalDate dateOfBirth;
    private String remark;
    private BloodGroup bloodGroup;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private List<Guardian> guardians;
    private List<Address> addresses;
    private List<Allergy> allergies;
    private List<Disease> diseases;
    private List<Document> documents;
    private LocalDateTime createdAt;
}
