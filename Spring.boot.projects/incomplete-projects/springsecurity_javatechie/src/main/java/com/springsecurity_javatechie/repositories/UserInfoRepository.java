package com.springsecurity_javatechie.repositories;

import com.springsecurity_javatechie.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserInfoRepository  extends JpaRepository<UserInfo, Integer> {


    @Query( value = "SELECT * FROM user_info WHERE name = :name", nativeQuery = true)
    Optional<UserInfo> findByName(@Param("name") String name);

}
