package com.toolshare.toolshare.Infraestructure.Repository.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.AuthService;
import com.toolshare.toolshare.Application.Service.JwtService;
import com.toolshare.toolshare.Domain.Users;
import com.toolshare.toolshare.Domain.Enum.TypeUsers;
import com.toolshare.toolshare.Domain.request.AuthResponse;
import com.toolshare.toolshare.Domain.request.LoginRequest;
import com.toolshare.toolshare.Domain.request.RegisterUserRequest;
import com.toolshare.toolshare.Infraestructure.Repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsersRepository usersRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = usersRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
        .token(token)
        .build();
    }

    @Override
    public AuthResponse Register(RegisterUserRequest request) {
        Users user = Users.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .type(request.getType())
        .build();

        usersRepository.save(user);

        return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
    }

    
}
