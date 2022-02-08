package com.demo.app.ws.dao.repositories;

import com.demo.app.ws.dao.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    public CityEntity findById(int id);
}
