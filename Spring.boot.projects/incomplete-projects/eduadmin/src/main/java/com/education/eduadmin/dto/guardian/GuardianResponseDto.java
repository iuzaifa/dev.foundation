package com.education.eduadmin.dto.guardian;

import lombok.Data;

@Data
public class GuardianResponseDto {


    private Long id;
    private String guardianName;
    private String relationship;
    private String contactNumber;
    private String email;
}
