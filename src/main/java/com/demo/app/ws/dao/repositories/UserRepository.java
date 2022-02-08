package com.demo.app.ws.dao.repositories;

import com.demo.app.ws.dao.entities.CompanyEntity;
import com.demo.app.ws.dao.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
    UserEntity findByPublicId(String publicId);
    Page<UserEntity> findByCompany(CompanyEntity company, Pageable pageable);
}
