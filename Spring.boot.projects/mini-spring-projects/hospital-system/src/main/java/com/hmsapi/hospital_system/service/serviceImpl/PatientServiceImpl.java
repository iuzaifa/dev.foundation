package com.hmsapi.hospital_system.service.serviceImpl;

import com.hmsapi.hospital_system.exception.AlreadyExistsException;
import com.hmsapi.hospital_system.exception.NotExistsException;
import com.hmsapi.hospital_system.mapper.PatientMapper;
import com.hmsapi.hospital_system.model.Patient;
import com.hmsapi.hospital_system.repository.PatientRepository;
import com.hmsapi.hospital_system.response.PatientRequest;
import com.hmsapi.hospital_system.response.PatientResponse;
import com.hmsapi.hospital_system.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;


    // GET ALL PATIENTS
    @Override
    public List<PatientResponse> getAllPatient() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::entityToResponse)
                .collect(Collectors.toList());
    }


    // REGISTER A PATIENT
    @Override
    public PatientResponse registerPatientDetails(PatientRequest patientRequest) {

        boolean exitsByEmail = patientRepository.existsByEmail(patientRequest.getEmail());
        boolean exitsByPhone = patientRepository.existsByContactNumber(patientRequest.getContactNumber());
        if (exitsByEmail && exitsByPhone) {
            throw new AlreadyExistsException("Both email and contact number already exist.");
        } else if (exitsByEmail) {
            throw new AlreadyExistsException("Email already exists: " + patientRequest.getEmail());
        } else if (exitsByPhone) {
            throw new AlreadyExistsException("Contact number already exists: " + patientRequest.getContactNumber());
        }
        Patient patient = PatientMapper.requestToEntity(patientRequest);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.entityToResponse(savedPatient);
    }


    // Patient get by id
    @Override
    public PatientResponse getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new NotExistsException("Patient Not exits with this id " + id));
        return PatientMapper.entityToResponse(patient);
    }

    @Override
    public PatientResponse getPatientByEmail(String email) {
        Patient patient = patientRepository.findByEmail(email)
                .orElseThrow(()-> new NotExistsException("Patient Not exits with this email " + email));
        return PatientMapper.entityToResponse(patient);
    }

    @Override
    public PatientResponse getPatientByPhone(String phone) {
        Patient patient = patientRepository.findByPhone(phone)
                .orElseThrow(()-> new NotExistsException("Patient Not exits with this phone " + phone));
        return PatientMapper.entityToResponse(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new NotExistsException("Patient Not exits with this id " + id));
        patientRepository.deleteById(id);

    }

    @Override
    public void deletePatientByEmail(String email) {
        Patient patient = patientRepository.findByEmail(email)
                .orElseThrow(()-> new NotExistsException("Patient Not exits with this email " + email));
        patientRepository.delete(patient);
    }



    @Override
    public PatientResponse updatePatientByEmail(String email, PatientRequest patientRequest) {
        Patient patient = patientRepository.findByEmail(email)
                .orElseThrow(()-> new NotExistsException("Patient Not exits with this email " + email));

        boolean exitsByEmail = patientRepository.existsByEmail(patientRequest.getEmail());
        boolean exitsByPhone = patientRepository.existsByContactNumber(patientRequest.getContactNumber());
        if (exitsByEmail && exitsByPhone) {
            throw new AlreadyExistsException("Both email and contact number already exist.");
        } else if (exitsByEmail) {
            throw new AlreadyExistsException("Email already exists: " + patientRequest.getEmail());
        } else if (exitsByPhone) {
            throw new AlreadyExistsException("Contact number already exists: " + patientRequest.getContactNumber());
        }

        patient.setName(patientRequest.getName());
        patient.setFatherName(patientRequest.getFatherName());
        patient.setMotherName(patientRequest.getMotherName());
        patient.setGender(patientRequest.getGender());
        patient.setAge(patientRequest.getAge());
        patient.setAddress(patientRequest.getAddress());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        patient.setBloodGroup(patientRequest.getBloodGroup());
        patient.setEmergencyContact(patientRequest.getEmergencyContact());
        patient.setAdmitted(patientRequest.isAdmitted());
        patient.setUpdatedAt(LocalDateTime.now());

        Patient updatePatient = patientRepository.save(patient);
        return PatientMapper.entityToResponse(updatePatient);
    }

    @Override
    public PatientResponse updatePatientById(Long id, PatientRequest patientRequest) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new NotExistsException("Patient Not exits with this id " + id));

        boolean exitsByEmail = patientRepository.existsByEmail(patientRequest.getEmail());
        boolean exitsByPhone = patientRepository.existsByContactNumber(patientRequest.getContactNumber());
        if (exitsByEmail && exitsByPhone) {
            throw new AlreadyExistsException("Both email and contact number already exist.");
        } else if (exitsByEmail) {
            throw new AlreadyExistsException("Email already exists: " + patientRequest.getEmail());
        } else if (exitsByPhone) {
            throw new AlreadyExistsException("Contact number already exists: " + patientRequest.getContactNumber());
        }
        patient.setName(patientRequest.getName());
        patient.setEmail(patientRequest.getEmail());
        patient.setFatherName(patientRequest.getFatherName());
        patient.setMotherName(patientRequest.getMotherName());
        patient.setGender(patientRequest.getGender());
        patient.setAge(patientRequest.getAge());
        patient.setContactNumber(patientRequest.getContactNumber());
        patient.setAddress(patientRequest.getAddress());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        patient.setBloodGroup(patientRequest.getBloodGroup());
        patient.setEmergencyContact(patientRequest.getEmergencyContact());
        patient.setAdmitted(patientRequest.isAdmitted());
        patient.setUpdatedAt(LocalDateTime.now());
        Patient updatePatient = patientRepository.save(patient);
        return PatientMapper.entityToResponse(updatePatient);
    }


    // REGISTER A PATIENT

}
