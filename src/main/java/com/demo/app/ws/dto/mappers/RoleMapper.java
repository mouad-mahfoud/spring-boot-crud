package com.demo.app.ws.dto.mappers;

import com.demo.app.ws.dao.entities.RoleEntity;
import com.demo.app.ws.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto(RoleEntity roleEntity);
    RoleEntity toEntity(RoleDto roleDto);
}
