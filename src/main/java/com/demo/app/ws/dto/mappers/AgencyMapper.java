package com.demo.app.ws.dto.mappers;


import com.demo.app.ws.dao.entities.AgencyEntity;
import com.demo.app.ws.dto.AgencyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AgencyMapper {
    @Mapping(source = "city.name", target = "cityName")
    AgencyDto toDto(AgencyEntity agencyEntity);
}
