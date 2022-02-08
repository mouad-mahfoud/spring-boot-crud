package com.demo.app.ws.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class RoleDto {

    @NotBlank
    public String name;
}
