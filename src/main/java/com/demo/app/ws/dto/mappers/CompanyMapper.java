package com.demo.app.ws.dto.mappers;

import com.demo.app.ws.dao.entities.CompanyEntity;
import com.demo.app.ws.dto.CompanyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface CompanyMapper {

    CompanyDto toCompanyDto(CompanyEntity companyEntity);

    CompanyEntity toCompanyEntity(CompanyDto companyDto);

    List<CompanyDto> toCompaniesDto(List<CompanyEntity> companyEntityList);
}
