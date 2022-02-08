package com.demo.app.ws.services;

import com.demo.app.ws.dao.repositories.RoleRepository;
import com.demo.app.ws.dto.RoleDto;
import com.demo.app.ws.dto.mappers.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleDto create(RoleDto roleDto){
        return roleMapper.toDto(roleRepository.save(roleMapper.toEntity(roleDto))) ;
    }
}
