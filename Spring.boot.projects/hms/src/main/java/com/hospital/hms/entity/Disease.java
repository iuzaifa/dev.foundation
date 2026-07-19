package com.hospital.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diseaseName;        // e.g., "Diabetes", "Asthma"
    private String type;               // e.g., "Chronic", "Acute"
    private String status;             // e.g., "Ongoing", "Recovered"
    private String diagnosedBy;        // Doctor name or ID
    private String diagnosedDate;      // Date of diagnosis
    private String notes;              // Additional remarks
}
