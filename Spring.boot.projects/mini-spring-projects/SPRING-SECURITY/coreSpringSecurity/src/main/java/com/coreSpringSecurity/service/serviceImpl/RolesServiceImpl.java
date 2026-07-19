package com.coreSpringSecurity.service.serviceImpl;

import com.coreSpringSecurity.dto.RolesDTO;
import com.coreSpringSecurity.mapper.RolesMapper;
import com.coreSpringSecurity.model.Roles;
import com.coreSpringSecurity.repository.RolesRepository;
import com.coreSpringSecurity.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository ;

    @Autowired
    private RolesMapper mapper;

    @Override
    public RolesDTO createRoles(RolesDTO rolesDTO) {
        // dto to entity
        Roles roles = mapper.toEntity(rolesDTO);
        // save into DB
        Roles savedRoles = rolesRepository.save(roles);
        // entity to dto
        return mapper.toDto(savedRoles);
    }
}
