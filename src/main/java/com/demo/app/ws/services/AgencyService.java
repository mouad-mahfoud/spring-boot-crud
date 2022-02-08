package com.demo.app.ws.services;

import com.demo.app.ws.dao.entities.AgencyEntity;
import com.demo.app.ws.dao.repositories.AgencyRepository;
import com.demo.app.ws.dao.repositories.CityRepository;
import com.demo.app.ws.dto.AgencyDto;
import com.demo.app.ws.dto.mappers.AgencyMapper;
import com.demo.app.ws.dto.requests.AddAgencyRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AgencyService {

    private CityRepository cityRepository;
    private AgencyRepository agencyRepository;
    private AgencyMapper agencyMapper;

    public AgencyDto create(AddAgencyRequest addAgencyRequest) {
        AgencyEntity agencyEntity = new AgencyEntity();
        agencyEntity.setName(addAgencyRequest.getName());
        agencyEntity.setCity(cityRepository.findById(addAgencyRequest.getCityId()));
        return agencyMapper.toDto(agencyRepository.save(agencyEntity));
    }
}
