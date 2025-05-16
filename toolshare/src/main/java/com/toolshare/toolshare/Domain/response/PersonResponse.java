package com.toolshare.toolshare.Domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String dateRegister;
    private String cellphone;
    private Long userId;
}
