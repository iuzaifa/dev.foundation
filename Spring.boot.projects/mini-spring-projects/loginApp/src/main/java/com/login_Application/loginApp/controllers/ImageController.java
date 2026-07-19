package com.login_Application.loginApp.controllers;

import com.login_Application.loginApp.payload.ImageDTO;
import com.login_Application.loginApp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    // Autowire the ImageService interface
    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<ImageDTO> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        ImageDTO imageDTO = imageService.saveImage(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(imageDTO);
    }
}
