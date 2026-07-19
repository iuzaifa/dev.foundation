package com.example.security_example.service;

import com.example.security_example.entity.Role;
import com.example.security_example.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role addNewRole(String role) {
        Role r = new Role();
        r.setRoleName(role.toString());
        return roleRepository.save(r);
    }

    @Override
    public void deleteRole(String roleName) {
        Role role = roleRepository.findByRole(roleName);
        if (role != null) {
            roleRepository.delete(role);
        } else {
            throw new RuntimeException("Role not found: " + roleName);
        }
    }


    @Override
    public Role getRoleById(Long roleId) {
        // 1. Fetch and validate in one step
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role Not found with ID: " + roleId));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
