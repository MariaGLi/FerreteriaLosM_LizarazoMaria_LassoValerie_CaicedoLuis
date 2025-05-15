package com.toolshare.toolshare.Application.Service;

import com.toolshare.toolshare.Domain.request.AuthResponse;
import com.toolshare.toolshare.Domain.request.LoginRequest;
import com.toolshare.toolshare.Domain.request.RegisterUserRequest;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);
    AuthResponse Register(RegisterUserRequest registerUserRequest);
}
