package com.toolshare.toolshare.Infraestructure.Repository.impl;

import java.util.Date;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.toolshare.toolshare.Application.Service.AuthService;
import com.toolshare.toolshare.Application.Service.JwtService;
import com.toolshare.toolshare.Domain.Persons;
import com.toolshare.toolshare.Domain.Users;
import com.toolshare.toolshare.Domain.request.LoginRequest;
import com.toolshare.toolshare.Domain.request.RegisterUserRequest;
import com.toolshare.toolshare.Domain.response.AuthResponse;
import com.toolshare.toolshare.Infraestructure.Repository.PersonRepository;
import com.toolshare.toolshare.Infraestructure.Repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UsersRepository usersRepository;
    private final PersonRepository personRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = usersRepository.findByUsername(request.getUsername()).orElseThrow();
        Users userID = usersRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        String type = user.getAuthorities().toString();
        //Long id = user.+
        return AuthResponse.builder()
        .token(token)
        .type(type.substring(6,type.length()-1))
        .id(userID.getId())
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

        Users newUser = usersRepository.findByUsername(request.getUsername()).get();

        Persons person = new Persons();
        person.setName(request.getName());
        person.setLast_name(request.getLastname());
        person.setCellphone(request.getCellphone());
        person.setEmail(request.getEmail());
        person.setDate_register(new Date());
        person.setId_user(newUser);

        personRepository.save(person);

        return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
    }

    
}
