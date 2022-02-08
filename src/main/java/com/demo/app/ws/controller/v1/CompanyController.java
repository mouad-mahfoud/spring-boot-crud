package com.demo.app.ws.controller.v1;

import com.demo.app.ws.dto.CompanyDto;
import com.demo.app.ws.dto.responses.PaginationResponse;
import com.demo.app.ws.services.CompanyService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/companies")
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @GetMapping
    public PaginationResponse getAllCompanies(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "5") int limit)
    {
        return companyService.getAllCompaniesWithPagination(page, limit);
    }

    @PostMapping()
    public ResponseEntity<CompanyDto> create(@RequestBody @Valid CompanyDto companyDto) {
        return new ResponseEntity(companyService.create(companyDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{publicId}")
    public ResponseEntity delete(@PathVariable String publicId) throws NotFoundException {
        this.companyService.delete(publicId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
