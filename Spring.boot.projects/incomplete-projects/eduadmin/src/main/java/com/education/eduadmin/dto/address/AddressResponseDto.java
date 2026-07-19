package com.education.eduadmin.dto.address;

import com.education.eduadmin.dto.student.StudentResponseDto;
import lombok.Data;

@Data
public class AddressResponseDto {

    private Long id;
    private String street1;
    private String street2; // Village and Post M...
    private String city; // Lucknow
    private String state; // Utter Pradesh
    private String country; // India
    private String zipCode; // 225207

    private StudentResponseDto studentResponseDto;




}
