package com.example.security_example.service;

import com.example.security_example.entity.Role;

import java.util.List;

public interface RoleService {

    Role addNewRole (String role);
    void deleteRole(String role);
    Role getRoleById(Long roleId);
    List<Role> getAllRoles ();
}
