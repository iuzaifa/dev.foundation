package com.website.mywebsite.service.serviceImpl;

import com.website.mywebsite.dto.LeadRequestDto;
import com.website.mywebsite.dto.LeadResponseDto;
import com.website.mywebsite.entity.Lead;
import com.website.mywebsite.exception.AlreadyExistException;
import com.website.mywebsite.mapper.LeadMapper;
import com.website.mywebsite.repository.LeadRepository;
import com.website.mywebsite.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeadServiceImpl implements LeadService {


    private final LeadMapper leadMapper;
    private final LeadRepository leadRepository;



    @Override
    public LeadResponseDto createNewLead(LeadRequestDto leadRequestDto) {
        Lead lead = leadMapper.toLeadEntity(leadRequestDto);
        Lead saveLead = leadRepository.save(lead);
        return leadMapper.toLeadResponse(saveLead);
    }

    @Override
    public List<LeadResponseDto> getAllLead() {
        return List.of();
    }

    @Override
    public LeadResponseDto leadGetByEmail(String email) {
        return null;
    }

    @Override
    public LeadResponseDto leadGetByPhone(String phone) {
        return null;
    }

    @Override
    public LeadResponseDto leadGetById(Long id) {
        return null;
    }

    @Override
    public void deleteLeadById(Long id) {

    }

    @Override
    public void deleteLeadByEmail(String email) {

    }

    @Override
    public void deleteLeadByPhone(String phone) {

    }

    @Override
    public LeadResponseDto updateLeadById(Long id) {
        return null;
    }
}
