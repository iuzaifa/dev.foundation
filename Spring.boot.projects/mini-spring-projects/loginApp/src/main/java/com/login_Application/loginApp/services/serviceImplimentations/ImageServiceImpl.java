package com.login_Application.loginApp.services.serviceImplimentations;

import com.login_Application.loginApp.entities.Image;
import com.login_Application.loginApp.payload.ImageDTO;
import com.login_Application.loginApp.repository.ImageRepository;
import com.login_Application.loginApp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Value("${image.upload.dir}")
    private String uploadDir;

    public ImageDTO saveImage(MultipartFile file) throws IOException {
        // Create a unique filename to avoid collisions
        String uniqueFileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        // Define the path to the "resources" directory (or wherever you want to store the images)
        Path filePath = Paths.get(uploadDir + File.separator + uniqueFileName);
        // Save the file to the specified path
        Files.copy(file.getInputStream(), filePath);
        // Create the Image entity and set its properties
        Image image = new Image();
        image.setName(file.getOriginalFilename());  // Store original filename
        image.setContentType(file.getContentType());  // Store content type (MIME type)
        image.setPath(filePath.toString());  // Save the file path in the database
        image.setUploadDate(LocalDateTime.now());
        // Save the image entity to the database
        Image savedImage = imageRepository.save(image);
        // Map the saved Image to ImageDTO (assuming you have a method for that)
        return new ImageDTO(savedImage);
    }


    @Override
    public ImageDTO getImageData(Long id) {
        return null;
    }

    @Override
    public List<ImageDTO> getAllImages() {
        return List.of();
    }


    // Converting ImageDto to Image Entity, but it can also be handled by Model Mapper.
    private ImageDTO dtoToEntity(Image entity) {
        ImageDTO response = new ImageDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setContentType(entity.getContentType());
        response.setUploadDate(entity.getUploadDate());
        return response;
    }
}
