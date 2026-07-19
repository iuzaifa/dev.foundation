package com.hospital.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String allergyName;        // e.g., "Peanut", "Dust", "Penicillin"
    private String severity;           // e.g., "Mild", "Moderate", "Severe"
    private String reaction;           // e.g., "Rash", "Breathing issue"
    private String notes;              // Doctor’s remarks
}
