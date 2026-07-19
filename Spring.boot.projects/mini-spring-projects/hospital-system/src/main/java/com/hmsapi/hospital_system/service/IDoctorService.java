package com.hmsapi.hospital_system.service;

import com.hmsapi.hospital_system.response.DoctorRequest;
import com.hmsapi.hospital_system.response.DoctorResponse;

import java.util.List;

public interface IDoctorService {

    List<DoctorResponse> getAllDoctors();

    DoctorResponse createDoctor(DoctorRequest doctorRequest);

    DoctorResponse getDoctorById (Long id);
    DoctorResponse getDoctorByEmail(String email);


    void deleteDoctorById(Long id);
    void deleteDoctorByEmail(String email);

    DoctorResponse updateDoctorById(Long id, DoctorRequest doctorRequest);
    DoctorResponse updateDoctorByEmail(String email, DoctorRequest doctorRequest);



}
