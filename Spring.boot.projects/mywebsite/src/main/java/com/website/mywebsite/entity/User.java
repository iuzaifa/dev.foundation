package com.website.mywebsite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String lastname;

    private String email;
    private String password;
    private String phoneNumber;

    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    private List<Role>   roles;
//    private List<Address> addresses;



}
