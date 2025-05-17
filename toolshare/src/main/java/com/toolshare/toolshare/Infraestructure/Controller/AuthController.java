package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolshare.toolshare.Application.Service.AuthService;
import com.toolshare.toolshare.Domain.request.LoginRequest;
import com.toolshare.toolshare.Domain.request.RegisterUserRequest;
import com.toolshare.toolshare.Domain.response.AuthResponse;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @RequestMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @RequestMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterUserRequest register) {
        return ResponseEntity.ok(authService.Register(register));
    }
    
}
