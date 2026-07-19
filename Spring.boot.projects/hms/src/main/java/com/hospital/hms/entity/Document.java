package com.hospital.hms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documents")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentNumber; // Document number (Aadhaar, Passport, etc.)
    private String documentPhoto; // File path or image URL of the ID document
    private String documentType;        // e.g. "Aadhaar Card", "Passport", "Driving License"
    private String remarks;  // Additional notes or comments
}
