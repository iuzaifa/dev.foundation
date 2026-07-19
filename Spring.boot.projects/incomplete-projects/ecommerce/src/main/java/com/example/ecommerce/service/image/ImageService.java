package com.example.ecommerce.service.image;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Image;
import com.example.ecommerce.repository.ImageRepository;
import com.example.ecommerce.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ImageService implements IImageService {

    private final ImageRepository imageRepository;
    private final IProductService productService;


    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No any image found with id "+ id));
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse( imageRepository :: delete,()-> {
            throw new ResourceNotFoundException("No any image found with id "+ id) ;
        });
    }

    @Override
    public Image saveImage(List<MultipartFile> files, Long productId) {
        return null;
    }

    @Override
    public void updateImage(MultipartFile file, Long id) {
        Image image = getImageById(id);
        try {
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImageData(file.getBytes());
            imageRepository.save(image);
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
