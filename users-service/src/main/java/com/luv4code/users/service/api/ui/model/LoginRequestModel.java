package com.luv4code.users.service.api.ui.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequestModel {
    private String email;
    private String password;
}
