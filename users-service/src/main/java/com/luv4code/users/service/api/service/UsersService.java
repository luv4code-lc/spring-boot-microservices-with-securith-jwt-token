package com.luv4code.users.service.api.service;

import com.luv4code.users.service.api.data.UserEntity;
import com.luv4code.users.service.api.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);

    UserDto getUserDetailsByEmail(String email);

    List<UserEntity> findAll();
}
