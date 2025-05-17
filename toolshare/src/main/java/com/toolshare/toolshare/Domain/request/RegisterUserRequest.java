package com.toolshare.toolshare.Domain.request;

import com.toolshare.toolshare.Domain.Enum.TypeUsers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String name;
    private String lastname;
    private String cellphone;
    private String email;
    private String username;
    private String password;
    private TypeUsers type;
}
