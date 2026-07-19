package com.example.security_example.repository;

import com.example.security_example.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RoleRepository extends JpaRepository<Role, Long> {


    @Query(value = "SELECT * FROM roles WHERE role_name =:roleName", nativeQuery = true)
    Role findByRole(String roleName);
}
