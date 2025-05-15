package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class pruebaController {
    @PostMapping("/users")
    public String hola() {
        return "holaa";
    }
    
}
