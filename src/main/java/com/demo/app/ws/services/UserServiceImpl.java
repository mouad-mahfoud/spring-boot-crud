package com.demo.app.ws.services;

import com.demo.app.ws.dao.entities.RoleEntity;
import com.demo.app.ws.dao.entities.UserEntity;
import com.demo.app.ws.dao.repositories.RoleRepository;
import com.demo.app.ws.dao.repositories.UserRepository;
import com.demo.app.ws.dto.mappers.UserMapper;
import com.demo.app.ws.exceptions.UserException;
import com.demo.app.ws.dto.responses.ErrorMessages;
import com.demo.app.ws.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final BCryptPasswordEncoder bCryptPasswordEncoder;
    final UserMapper userMapper;

    @Override
    public UserEntity createUser(UserDto userDto) {

        if (userDto.getFirstName().isEmpty())
            throw new UserException(ErrorMessages.MISSING_REQUIRED_FIELLD.getErrorMessage());

        // TODO: catch it from hebernate and remove this condition
        if (userRepository.findByEmail(userDto.getEmail()) != null) throw new RuntimeException("User already exists !");

        UserEntity userEntity = userMapper.toUserEntity(userDto);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userEntity = userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        return userMapper.toUserDto(userEntity);
    }

    @Override
    public UserDto getUserById(String userId) {
        UserEntity userEntity = userRepository.findByPublicId(userId);
        if (userEntity == null) {
            throw new UsernameNotFoundException("user not found : " + userId);
        }
        return userMapper.toUserDto(userEntity);
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        UserEntity userEntity = userRepository.findByPublicId(userId);
        if (userEntity == null) {
            throw new UsernameNotFoundException(userId);
        }
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());

        return userMapper.toUserDto(userRepository.save(userEntity));

    }

    @Override
    public void deleteUser(String userId) {
        UserEntity userEntity = userRepository.findByPublicId(userId);
        if (userEntity == null) {
            throw new UsernameNotFoundException(userId);
        }
        userRepository.delete(userEntity);
    }

    @Override
    public UserDto addRoleToUser(String userPublicId, String roleName) {
        UserEntity user = userRepository.findByPublicId(userPublicId);
        RoleEntity role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        return userMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> getUsers(int page, int limit) {

        if (page > 0) page -= 1;

        Page<UserEntity> userEntityPage = userRepository.findAll(PageRequest.of(page, limit));

        List<UserEntity> users = userEntityPage.getContent();

        return userMapper.toUsersDto(users);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userEntity.getRoles().forEach(roleEntity -> {
            authorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
        });
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), authorities);
    }
}
