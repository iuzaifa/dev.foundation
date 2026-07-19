package com.hmsapi.hospital_system.response;

import lombok.Data;

import java.time.LocalDate;


@Data
public class PatientResponse {

    private Long id;
    private String email;
    private String name;
    private String fatherName;
    private String motherName;
    private String gender;
    private int age;

    private String contactNumber;
    private String address;
    private LocalDate dateOfBirth;
    private String bloodGroup;
    private String emergencyContact;
    private boolean admitted;



}
