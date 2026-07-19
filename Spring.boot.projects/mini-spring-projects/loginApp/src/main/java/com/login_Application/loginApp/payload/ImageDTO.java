package com.login_Application.loginApp.payload;

import com.login_Application.loginApp.entities.Image;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private Long id;
    private String name;
    private String contentType;
    private LocalDateTime uploadDate;
    private String path; // Path to the image file on the filesystem

    public ImageDTO(Image savedImage) {
    }


//    @Lob
//    private byte[] data;
}
