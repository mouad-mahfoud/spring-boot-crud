package com.demo.app.ws.services;

import com.demo.app.ws.dao.entities.CompanyEntity;
import com.demo.app.ws.dao.entities.RoleEntity;
import com.demo.app.ws.dao.entities.UserEntity;
import com.demo.app.ws.dao.repositories.CompanyRepository;
import com.demo.app.ws.dao.repositories.RoleRepository;
import com.demo.app.ws.dto.CompanyDto;
import com.demo.app.ws.dto.mappers.CompanyMapper;
import com.demo.app.ws.dto.responses.PaginationResponse;
import com.demo.app.ws.shared.enums.Role;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyMapper companyMapper;
    private CompanyRepository companyRepository;
    private UserService userService;
    private RoleRepository roleRepository;

    public PaginationResponse getAllCompaniesWithPagination(int page, int limit) {
        if (page > 0) page -= 1;

        Page<CompanyEntity> companyEntityPage = companyRepository.findAll(PageRequest.of(page, limit));

        List<CompanyEntity> companies = companyEntityPage.getContent();
        PaginationResponse paginationResponse = new PaginationResponse<CompanyDto>(
                companyMapper.toCompaniesDto(companies),
                companyEntityPage.getTotalElements()
        );
        return paginationResponse;
    }

    public CompanyDto create(CompanyDto companyDto) {
        UserEntity userEntity = userService.createUser(companyDto.getManager());
        RoleEntity role = roleRepository.findByName(Role.ROLE_COMPANY_ADMIN.toString());
        userEntity.getRoles().add(role);
        CompanyEntity companyEntity = companyMapper.toCompanyEntity(companyDto);
        companyEntity.setManager(userEntity);
        return companyMapper.toCompanyDto(companyRepository.save(companyEntity));
    }

    public void delete(String publicId) throws NotFoundException {
        CompanyEntity companyEntity = companyRepository.findByPublicId(publicId);
        if (companyEntity == null)
            throw new NotFoundException(publicId);
        companyRepository.delete(companyEntity);
    }
}
