package com.demo.app.ws.services;

import com.demo.app.ws.dao.entities.CompanyEntity;
import com.demo.app.ws.dao.entities.UserEntity;
import com.demo.app.ws.dao.repositories.CompanyRepository;
import com.demo.app.ws.dao.repositories.UserRepository;
import com.demo.app.ws.dto.mappers.UserMapper;
import com.demo.app.ws.dto.responses.PaginationResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AgentService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private CompanyRepository companyRepository;

    public PaginationResponse getAgentsByCompanyAdmin(String companyPublicId, int page, int limit) {
        if (page > 0) page -= 1;

        CompanyEntity companyEntity = companyRepository.findByPublicId(companyPublicId);
        Page<UserEntity> userEntityPage = userRepository.findByCompany(companyEntity, PageRequest.of(page, limit));
        List<UserEntity> users = userEntityPage.getContent();
        PaginationResponse paginationResponse = new PaginationResponse(
                userMapper.toUsersDto(users),
                userEntityPage.getTotalElements()
        );
        return paginationResponse;
    }
}
