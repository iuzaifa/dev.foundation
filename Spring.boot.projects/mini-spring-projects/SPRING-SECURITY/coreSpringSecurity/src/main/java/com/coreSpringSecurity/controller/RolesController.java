package com.coreSpringSecurity.controller;

import com.coreSpringSecurity.constants.CommonConstants;
import com.coreSpringSecurity.dto.RolesDTO;
import com.coreSpringSecurity.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CommonConstants.ROLES_BASE_PATH)
public class RolesController {

    @Autowired
    private RolesService rolesService;




    @PostMapping(CommonConstants.CREATE_ROLES)
    public ResponseEntity<?> createRoles(@RequestBody RolesDTO rolesDTO){
        return new ResponseEntity<>(rolesService.createRoles(rolesDTO), HttpStatus.CREATED);
    }
}
