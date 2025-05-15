package com.toolshare.toolshare.Infraestructure.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // desactiva CSRF para probar desde Postman
            .authorizeHttpRequests()
                .anyRequest().permitAll(); // permite todos los endpoints sin autenticación
        return http.build();
    }
}
