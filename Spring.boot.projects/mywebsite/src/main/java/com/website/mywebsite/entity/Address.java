//package com.website.mywebsite.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@Entity
//public class Address {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String street;
//    private String city;
//    private String stateProvince;
//    private String zipPostalCode;
//    private String country;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//}
