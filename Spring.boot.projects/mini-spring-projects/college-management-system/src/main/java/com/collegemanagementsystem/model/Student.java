package com.collegemanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Basic Details

    private String firstName;
    private String lastName;
    private String email;
    private String gender; // Best practice: use an Enum for fixed categories like gender
    private LocalDate dateOfBirth;
    private String password;
    private String confirmPassword;


    // Academic Info
    private String standard; //  Consider using an enum for 'standard' if options are fixed (e.g., "1st", "2nd")
//    private String studentId; // Unique ID (e.g., college roll number)
//    private String department;
//    private String course; // Or use @ManyToOne to relate with a Course entity
//    private int semester;
//    private int yearOfStudy;
//    private LocalDate admissionDate;


    // Address
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;

//    @ManyToOne
//    @JoinColumn(name = "guardian_id")
//    private Guardian guardian;
//
//
//    @ManyToMany
//    private List<Subject> subjects;
//
//    @OneToMany(mappedBy = "student")
//    private List<Enrollment> enrollments;
//
//

    // System Info
    private boolean isActive; // No @NotBlank/@NotEmpty for booleans
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
