package com.website.mywebsite.controller;

import com.website.mywebsite.dto.LeadRequestDto;
import com.website.mywebsite.service.LeadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/lead")
@CrossOrigin(origins = "http://localhost:5173") // your React URL
public class LeadController {

    private final LeadService leadService;




    @PostMapping("/new-lead")
    public ResponseEntity<?> createNewLead(@Valid @RequestBody LeadRequestDto requestDto){
        return new ResponseEntity<>(leadService.createNewLead(requestDto), HttpStatus.CREATED);

    }
}
