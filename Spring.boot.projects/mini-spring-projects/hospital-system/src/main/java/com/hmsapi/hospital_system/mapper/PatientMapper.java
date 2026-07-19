package com.hmsapi.hospital_system.mapper;

import com.hmsapi.hospital_system.model.Patient;
import com.hmsapi.hospital_system.response.PatientRequest;
import com.hmsapi.hospital_system.response.PatientResponse;

public class PatientMapper {


    // Convert Patient entity to PatientResponse (for API output)
    public static PatientResponse entityToResponse(Patient patient) {
        if (patient == null) return null;
        PatientResponse response = new PatientResponse();
        response.setId(patient.getId());
        response.setName(patient.getName());
        response.setEmail(patient.getEmail());
        response.setFatherName(patient.getFatherName());
        response.setMotherName(patient.getMotherName());
        response.setGender(patient.getGender());
        response.setAge(patient.getAge());
        response.setAddress(patient.getAddress());
        response.setContactNumber(patient.getContactNumber());
        response.setDateOfBirth(patient.getDateOfBirth());
        response.setBloodGroup(patient.getBloodGroup());
        response.setEmergencyContact(patient.getEmergencyContact());
        response.setAdmitted(patient.isAdmitted());
        return response;
    }

    public static Patient requestToEntity(PatientRequest request) {
        if (request == null) return null;

        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setEmail(request.getEmail());
        patient.setFatherName(request.getFatherName());
        patient.setMotherName(request.getMotherName());
        patient.setGender(request.getGender());
        patient.setAge(request.getAge());
        patient.setAddress(request.getAddress());
        patient.setContactNumber(request.getContactNumber());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setEmergencyContact(request.getEmergencyContact());
        patient.setAdmitted(request.isAdmitted());

        return patient;

    }
}
