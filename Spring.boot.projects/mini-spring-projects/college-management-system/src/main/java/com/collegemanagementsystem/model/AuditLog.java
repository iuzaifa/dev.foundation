package com.collegemanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private String Student;      // Example: "Student"
    private String entityName;

    private String fieldName;       // Example: email, name, address,
    private String oldValue;
    private String newValue;

    private String updatedBy;       // Username or ID
    private LocalDateTime updatedAt;
}
