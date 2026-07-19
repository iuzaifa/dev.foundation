package com.login_Application.loginApp.repository;

import com.login_Application.loginApp.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
