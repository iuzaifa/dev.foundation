package com.login_Application.loginApp.services;

import com.login_Application.loginApp.payload.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    ImageDTO saveImage(MultipartFile file) throws IOException;
    ImageDTO getImageData(Long id);
    List<ImageDTO> getAllImages();
}
