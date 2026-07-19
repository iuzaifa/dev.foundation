package com.SecuredEntityMappings.repository;

import com.SecuredEntityMappings.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
