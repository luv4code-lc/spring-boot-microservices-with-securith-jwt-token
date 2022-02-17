package com.luv4code.users.service.api.ui.controller;

import com.luv4code.users.service.api.data.UserEntity;
import com.luv4code.users.service.api.service.UsersService;
import com.luv4code.users.service.api.shared.UserDto;
import com.luv4code.users.service.api.ui.model.CreateUserRequestModel;
import com.luv4code.users.service.api.ui.model.CreateUserResponseModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;
    private final Environment environment;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> usersList = usersService.findAll();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(userDetails, UserDto.class);
        UserDto createdUser = usersService.createUser(userDto);

        CreateUserResponseModel response = mapper.map(createdUser, CreateUserResponseModel.class);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
