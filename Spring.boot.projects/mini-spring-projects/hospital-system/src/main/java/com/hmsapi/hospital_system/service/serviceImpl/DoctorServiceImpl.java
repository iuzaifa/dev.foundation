package com.hmsapi.hospital_system.service.serviceImpl;

import com.hmsapi.hospital_system.exception.AlreadyExistsException;
import com.hmsapi.hospital_system.exception.NotExistsException;
import com.hmsapi.hospital_system.mapper.DoctorMapper;
import com.hmsapi.hospital_system.model.Doctor;
import com.hmsapi.hospital_system.repository.DoctorRepository;
import com.hmsapi.hospital_system.response.DoctorRequest;
import com.hmsapi.hospital_system.response.DoctorResponse;
import com.hmsapi.hospital_system.service.IDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements IDoctorService {


    private final DoctorRepository doctorRepository;

    @Override
    public List<DoctorResponse> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(DoctorMapper::entityToResponse)
                .collect(Collectors.toList());
    }



    @Override
    public DoctorResponse createDoctor(DoctorRequest doctorRequest) {
        boolean isExitsEmail = doctorRepository.existsByEmail(doctorRequest.getEmail());
        boolean isPhoneExits = doctorRepository.existsByContactNumber(doctorRequest.getContactNumber());
        if (isPhoneExits && isExitsEmail) {
            throw new AlreadyExistsException("Doctor Email and Contact Number already exists. Please try another: "
                    + doctorRequest.getEmail() + ", " + doctorRequest.getContactNumber());
        }
        if (isExitsEmail){
            throw new AlreadyExistsException("Doctor email already exists. Please try another: " + doctorRequest.getEmail());
        }
        if (isPhoneExits){
            throw new AlreadyExistsException("Doctor Contact Number already exists. Please try another: " + doctorRequest.getContactNumber());
        }
        Doctor doctor = doctorRepository.save(DoctorMapper.requestToEntity(doctorRequest));
        return DoctorMapper.entityToResponse(doctor);
    }

    @Override
    public DoctorResponse getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new NotExistsException("Doctor Id not Found Try another Id : "+ id));
        return DoctorMapper.entityToResponse(doctor);
    }

    @Override
    public DoctorResponse getDoctorByEmail(String email) {
        Doctor doctor = doctorRepository.findByEmail(email)
                .orElseThrow(() -> new NotExistsException(String.format(String.format("Doctor with email '%s' not found. Please try another email.", email))));
        return DoctorMapper.entityToResponse(doctor);
    }


    @Override
    public void deleteDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new NotExistsException(String.format("Doctor with ID %d not found. Please try another ID.", id)));
        doctorRepository.delete(doctor);
    }

    @Override
    public void deleteDoctorByEmail(String email) {
        Doctor doctor = doctorRepository.findByEmail(email)
                .orElseThrow(()-> new NotExistsException(String.format(String.format("Doctor with email '%s' not found. Please try another email.", email))));
        doctorRepository.delete(doctor);
    }


    @Override
    public DoctorResponse updateDoctorById(Long id, DoctorRequest doctorRequest) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new NotExistsException(String.format("Doctor with ID %d not found. Please try another ID.", id)));
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
        doctor.setUpdatedAt(LocalDateTime.now());

        Doctor update = doctorRepository.save(doctor);
        return DoctorMapper.entityToResponse(update);

    }

    @Override
    public DoctorResponse updateDoctorByEmail(String email, DoctorRequest doctorRequest) {
        Doctor doctor = doctorRepository.findByEmail(email)
                .orElseThrow(()-> new NotExistsException(String.format(String.format("Doctor with email '%s' not found. Please try another email.", email))));

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
        doctor.setUpdatedAt(LocalDateTime.now());

        Doctor update = doctorRepository.save(doctor);
        return DoctorMapper.entityToResponse(update);
    }
}
