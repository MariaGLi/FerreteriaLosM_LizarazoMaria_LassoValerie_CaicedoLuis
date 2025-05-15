package com.toolshare.toolshare.Application.Service;

import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {

    String getToken(UserDetails userDetails);

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userdetails);

}
