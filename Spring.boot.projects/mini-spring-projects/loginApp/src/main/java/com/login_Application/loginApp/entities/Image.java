package com.login_Application.loginApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contentType;
    @Column(nullable = false)
    private LocalDateTime uploadDate;
    private String path; // Path to the image file on the filesystem

    @Lob
    private byte[] data;


    public Image(String originalFilename, String contentType, byte[] bytes) {
    }
}
