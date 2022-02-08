package com.demo.app.ws.controller.v1;

import com.demo.app.ws.dto.RoleDto;
import com.demo.app.ws.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
public class RoleController  {

    private final RoleService roleService;

    @PostMapping()
    public ResponseEntity<RoleDto> create(@RequestBody @Valid RoleDto roleDto){
       return new ResponseEntity(roleService.create(roleDto), HttpStatus.CREATED);
    }
}
