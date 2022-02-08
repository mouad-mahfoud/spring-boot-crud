package com.demo.app.ws.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompanyDto {

    private String publicId;
    private String name;
    private String address;
    private String logo;
    private UserDto manager;
}
