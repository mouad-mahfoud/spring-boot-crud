package com.demo.app.ws.services;

import com.demo.app.ws.dao.entities.UserEntity;
import com.demo.app.ws.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserEntity createUser(UserDto userDto);
    UserDto getUser(String email);
    UserDto getUserById(String userId);
    UserDto updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
    UserDto addRoleToUser(String userPublicId, String roleName);
    List<UserDto> getUsers(int page, int limit);
}
