package com.hospital.hms.dto;

import com.hospital.hms.entity.Address;
import com.hospital.hms.entity.BloodGroup;
import com.hospital.hms.entity.Patient;
import lombok.Data;

import java.util.List;

@Data
public class GuardianResponseDto {


    private Long id;

    private String name;
    private String relation; // e.g. Father, Mother, Spouse, etc.

    private String phone;
    private String email;
    private BloodGroup bloodGroup;
    private Address address;
    private List<Patient> patients;
}
