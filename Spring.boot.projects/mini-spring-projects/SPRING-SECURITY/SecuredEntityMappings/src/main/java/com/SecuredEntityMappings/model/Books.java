package com.SecuredEntityMappings.model;

import jakarta.persistence.*;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;



    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}