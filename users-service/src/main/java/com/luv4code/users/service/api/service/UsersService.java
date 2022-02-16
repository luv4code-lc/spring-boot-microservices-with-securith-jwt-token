package com.luv4code.users.service.api.service;

import com.luv4code.users.service.api.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);

    UserDto getUserDetailsByEmail(String email);
}
