package com.education.eduadmin.repository;

import com.education.eduadmin.entity.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Long> {

    boolean existsByEmail(@NotNull(message = "Email is required") @Email(message = "Email should be valid") String email);
    boolean existsByPhone(@NotNull(message = "Phone number is required") String phone);
}
