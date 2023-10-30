package com.anilakdemir.cotaskapplication.dto.request.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {

    private String email;
    private String username;
    private String password;
}
