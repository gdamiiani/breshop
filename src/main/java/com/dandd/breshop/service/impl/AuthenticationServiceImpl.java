package com.dandd.breshop.service.impl;

import com.dandd.breshop.dto.LoginDTO;
import com.dandd.breshop.dto.AuthenticationDTO;
import com.dandd.breshop.dto.CreateUserDTO;
import com.dandd.breshop.service.JWTService;
import com.dandd.breshop.utils.Role;
import com.dandd.breshop.entity.User;
import com.dandd.breshop.repository.UserRepository;
import com.dandd.breshop.service.AuthenticationService;
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
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationDTO register(CreateUserDTO request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var token = jwtService.generateToken(user);

        return AuthenticationDTO.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthenticationDTO authenticate(LoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var token = jwtService.generateToken(user);

        return AuthenticationDTO.builder()
                .token(token)
                .build();
    }
}
