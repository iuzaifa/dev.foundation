package com.SecuredEntityMappings.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class UserProfile {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String phone;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
