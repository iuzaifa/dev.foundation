package com.website.mywebsite.service;

import com.website.mywebsite.dto.LeadRequestDto;
import com.website.mywebsite.dto.LeadResponseDto;
import com.website.mywebsite.entity.Lead;

import java.util.List;

public interface LeadService {

    LeadResponseDto createNewLead(LeadRequestDto leadRequestDto);

    List<LeadResponseDto> getAllLead();
    LeadResponseDto leadGetByEmail(String email);
    LeadResponseDto leadGetByPhone(String phone);
    LeadResponseDto leadGetById(Long id);

    void deleteLeadById(Long id);
    void deleteLeadByEmail(String email);
    void deleteLeadByPhone(String phone);

    LeadResponseDto updateLeadById(Long id);







}
