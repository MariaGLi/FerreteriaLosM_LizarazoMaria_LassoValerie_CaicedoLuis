package com.toolshare.toolshare.Domain.response;

import java.util.Date;

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
    private Date dateRegister;
    private String cellphone;
    private Long userId;
}
