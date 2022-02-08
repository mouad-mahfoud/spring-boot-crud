package com.demo.app.ws.controller.v1;

import com.demo.app.ws.dto.AgencyDto;
import com.demo.app.ws.dto.requests.AddAgencyRequest;
import com.demo.app.ws.services.AgencyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/V1/agencies")
@AllArgsConstructor
public class AgencyController {

    public AgencyService agencyService;

    @GetMapping
    public List<> getAllByCompany

    @PostMapping
    public ResponseEntity<AgencyDto> create(@RequestBody @Valid AddAgencyRequest agencyRequest) {
        return new ResponseEntity(agencyService.create(agencyRequest), HttpStatus.CREATED);
    }

}
