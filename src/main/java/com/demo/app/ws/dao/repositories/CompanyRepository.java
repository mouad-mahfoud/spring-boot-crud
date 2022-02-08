package com.demo.app.ws.dao.repositories;

import com.demo.app.ws.dao.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    CompanyEntity findByPublicId(String publicId);
}
