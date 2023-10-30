package com.anilakdemir.cotaskapplication.service.impl;

import com.anilakdemir.cotaskapplication.config.security.JwtService;
import com.anilakdemir.cotaskapplication.dto.request.auth.AuthenticationRequest;
import com.anilakdemir.cotaskapplication.dto.request.auth.UserRegisterRequest;
import com.anilakdemir.cotaskapplication.dto.response.auth.AuthenticationResponse;
import com.anilakdemir.cotaskapplication.model.Role;
import com.anilakdemir.cotaskapplication.model.User;
import com.anilakdemir.cotaskapplication.repository.UserRepository;
import com.anilakdemir.cotaskapplication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(UserRegisterRequest userRegisterRequest) {
        User user = User.builder()
                .email(userRegisterRequest.getEmail())
                .username(userRegisterRequest.getUsername())
                .password(passwordEncoder.encode(userRegisterRequest.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        User user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User could not found"));

        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
