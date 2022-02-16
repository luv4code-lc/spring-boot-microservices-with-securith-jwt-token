package com.luv4code.users.service.api.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestModel {

    @NotNull(message = "Firstname cannot be null")
    @Size(min = 2, message = "Firstname must not be less than 2 characters")
    private String firstName;

    @NotNull(message = "Lastname cannot be null")
    @Size(min = 2, message = "Lastname must not be less than 2 characters")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be equal or grater than 8 characters and less than 16 characters")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
}
