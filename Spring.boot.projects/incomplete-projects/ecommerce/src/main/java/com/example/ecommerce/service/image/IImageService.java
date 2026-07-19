package com.example.ecommerce.service.image;

import com.example.ecommerce.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {

    Image getImageById(Long id);
    void deleteImageById(Long id);

    Image saveImage(List<MultipartFile> files , Long productId);
    void updateImage(MultipartFile file, Long id );
}
