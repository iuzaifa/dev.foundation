package com.education.eduadmin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street1;
    private String street2; // Village and Post M...
    private String city; // Lucknow
    private String state; // Utter Pradesh
    private String country; // India
    private String zipCode; // 225207


    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Student student;



}
