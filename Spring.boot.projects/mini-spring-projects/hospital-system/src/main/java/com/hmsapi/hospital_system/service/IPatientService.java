package com.hmsapi.hospital_system.service;


import com.hmsapi.hospital_system.response.PatientRequest;
import com.hmsapi.hospital_system.response.PatientResponse;

import java.util.List;

public interface IPatientService {


    List<PatientResponse> getAllPatient();

    PatientResponse registerPatientDetails(PatientRequest patientRequest);

    PatientResponse getPatientById(Long id);
    PatientResponse getPatientByEmail(String email);
    PatientResponse getPatientByPhone(String phone);

    void deletePatientById(Long id);
    void deletePatientByEmail(String email);

    PatientResponse updatePatientByEmail(String email, PatientRequest patientRequest);
    PatientResponse updatePatientById(Long id, PatientRequest patientRequest);




}
