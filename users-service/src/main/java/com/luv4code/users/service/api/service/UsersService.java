package com.luv4code.users.service.api.service;

import com.luv4code.users.service.api.shared.UserDto;

public interface UsersService {
    UserDto createUser(UserDto userDetails);
}
