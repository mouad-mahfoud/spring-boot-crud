package com.demo.app.ws.dao.repositories;

import com.demo.app.ws.dao.entities.AgencyEntity;
import com.demo.app.ws.dao.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<AgencyEntity, Long> {
}
