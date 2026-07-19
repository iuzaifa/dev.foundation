package com.website.mywebsite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String companyName;
    private String email;
    private String phone;
    private String inquiry;
    private String message;

    @Enumerated(EnumType.STRING)
    private LeadStatus status; // NEW, CONTACTED, QUALIFIED, DISQUALIFIED
    @Enumerated(EnumType.STRING)
    private LeadSource source; // WEBSITE, REFERRAL, COLD_CALL, etc.

//    private List<Address> addresses;




}
