package com.academiapro.cms.entiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileUrl;
    private String docType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
