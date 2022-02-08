package com.demo.app.ws.dto.mappers;

import com.demo.app.ws.dao.entities.UserEntity;
import com.demo.app.ws.dto.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {CompanyMapper.class}
)
public interface UserMapper {

    @Mapping(source = "roles", target = "roleDtoSet")
    @Mapping(source = "company", target = "companyDto")
    @Mapping(target = "companyDto.manager", ignore = true)
    UserDto toUserDto(UserEntity userEntity);

    @Mapping(source = "roles", target = "roleDtoSet")
    List<UserDto> toUsersDto(List<UserEntity> usersEntity);

    @Mapping(source = "roleDtoSet", target = "roles")
    @Mapping(source = "companyDto", target = "company")
    UserEntity toUserEntity(UserDto userDto);
}
