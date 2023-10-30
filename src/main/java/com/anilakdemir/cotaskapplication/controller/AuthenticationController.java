package com.anilakdemir.cotaskapplication.controller;

import com.anilakdemir.cotaskapplication.dto.request.auth.AuthenticationRequest;
import com.anilakdemir.cotaskapplication.dto.request.auth.UserRegisterRequest;
import com.anilakdemir.cotaskapplication.dto.response.auth.AuthenticationResponse;
import com.anilakdemir.cotaskapplication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        return ResponseEntity.ok(authenticationService.register(userRegisterRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
