package com.example.security_example.controller;

import com.example.security_example.dto.RoleRequest;
import com.example.security_example.entity.Role;
import com.example.security_example.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody RoleRequest request){
        return new ResponseEntity<>(
                roleService.addNewRole(request.getRoleName()),
                HttpStatus.CREATED
        );
    }


    @GetMapping("/get-all")
    public ResponseEntity<?> getAllRoles(){
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable("id") Long id){
        return new ResponseEntity<>(roleService.getRoleById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{role}")
    public ResponseEntity<?> deleteRole(@PathVariable String role){
        String message = "Deleted Successfully " + role;
        roleService.deleteRole(role);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}
