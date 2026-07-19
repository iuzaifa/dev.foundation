package com.hmsapi.hospital_system.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class ExceptionResponseDTO {

    private String aipPath;
    private String statusCode;
    private String errorMessage;
    private String errorTime;



}