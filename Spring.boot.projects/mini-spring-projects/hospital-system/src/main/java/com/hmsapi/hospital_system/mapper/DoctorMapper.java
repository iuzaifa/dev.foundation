package com.hmsapi.hospital_system.mapper;

import com.hmsapi.hospital_system.model.Doctor;
import com.hmsapi.hospital_system.response.DoctorRequest;
import com.hmsapi.hospital_system.response.DoctorResponse;


public class DoctorMapper {


    public static DoctorResponse entityToResponse(Doctor doctor) {
        if (doctor == null) return null;

        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setName(doctor.getName());
        response.setEmail(doctor.getEmail());
        response.setFatherName(doctor.getFatherName());
        response.setGender(doctor.getGender());
        response.setAge(doctor.getAge());

        response.setContactNumber(doctor.getContactNumber());
        response.setSpecialization(doctor.getSpecialization());
        response.setQualification(doctor.getQualification());
        response.setYearsOfExperience(doctor.getYearsOfExperience());
        response.setJoiningDate(doctor.getJoiningDate());
        response.setStatus(doctor.getStatus());
        response.setAvailable(doctor.isAvailable());
        return response;
    }


    public static Doctor requestToEntity(DoctorRequest doctorRequest){
        if (doctorRequest == null) return null;

        Doctor doctor = new Doctor();

        doctor.setName(doctorRequest.getName());
        doctor.setEmail(doctorRequest.getEmail());
        doctor.setFatherName(doctorRequest.getFatherName());
        doctor.setGender(doctorRequest.getGender());
        doctor.setAge(doctorRequest.getAge());

        doctor.setContactNumber(doctorRequest.getContactNumber());
        doctor.setSpecialization(doctorRequest.getSpecialization());
        doctor.setQualification(doctorRequest.getQualification());
        doctor.setYearsOfExperience(doctorRequest.getYearsOfExperience());
        doctor.setJoiningDate(doctorRequest.getJoiningDate());
        doctor.setStatus(doctorRequest.getStatus());
        doctor.setAvailable(doctorRequest.isAvailable());

        return doctor;
    }
}
