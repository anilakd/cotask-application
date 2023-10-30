package com.anilakdemir.cotaskapplication.service;

import com.anilakdemir.cotaskapplication.dto.request.auth.AuthenticationRequest;
import com.anilakdemir.cotaskapplication.dto.request.auth.UserRegisterRequest;
import com.anilakdemir.cotaskapplication.dto.response.auth.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(UserRegisterRequest userRegisterRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
