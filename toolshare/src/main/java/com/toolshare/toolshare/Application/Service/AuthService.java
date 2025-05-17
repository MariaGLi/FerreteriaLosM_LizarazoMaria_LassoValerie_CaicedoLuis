package com.toolshare.toolshare.Application.Service;

import com.toolshare.toolshare.Domain.request.LoginRequest;
import com.toolshare.toolshare.Domain.request.RegisterUserRequest;
import com.toolshare.toolshare.Domain.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest);
    AuthResponse Register(RegisterUserRequest registerUserRequest);
}
