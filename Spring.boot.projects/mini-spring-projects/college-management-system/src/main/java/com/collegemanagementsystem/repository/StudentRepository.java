package com.collegemanagementsystem.repository;

import com.collegemanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    @Query(value = "SELECT * FROM student WHERE LOWER(email) = LOWER(:email)", nativeQuery = true)
    Optional<Student> findByEmail (@Param("email") String email);



}
