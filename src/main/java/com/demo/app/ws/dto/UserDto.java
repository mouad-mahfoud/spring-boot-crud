package com.demo.app.ws.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    private String publicId;
    private String firstName;
    private String lastName;
    private String email;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;
    private String password;
    private String encryptedPassword;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<RoleDto> roleDtoSet = new HashSet();
    private CompanyDto companyDto;

}
