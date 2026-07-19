package com.hospital.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressType;     // e.g., "Permanent", "Current", "Office"
    private String street;          // e.g., "123 Main Street"
    private String city;            // Barabanki
    private String state;           // U.P
    private String district;        // Barabanki
    private String postalCode;      // e.g., 110022
    private String country;         // e.g , India

    private String landmark;       // Optional
    private Boolean isPrimary;  // For marking main address
}
