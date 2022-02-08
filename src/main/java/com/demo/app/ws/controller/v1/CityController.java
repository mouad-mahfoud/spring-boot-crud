package com.demo.app.ws.controller.v1;


import com.demo.app.ws.dao.entities.CityEntity;
import com.demo.app.ws.dao.repositories.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/cities")
@AllArgsConstructor
public class CityController {
    public CityRepository cityRepository;

    @GetMapping()
    public List<CityEntity> getAll(){
        return cityRepository.findAll();
    }
}
