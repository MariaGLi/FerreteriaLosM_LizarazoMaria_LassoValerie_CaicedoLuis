package com.toolshare.toolshare.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.toolshare.toolshare.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        return http
        .csrf(csrf -> csrf.disable())
        .cors(cors -> cors.configurationSource(corsConfiguration()))
        .authorizeHttpRequests(auth -> 
        auth
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers("/api/admin/**").hasRole("Admin")
            .requestMatchers("/InventoryManagment/**").hasRole("Supplier")
            .requestMatchers("/api/customer/**").hasRole("Customer")
            .requestMatchers("/reservationManagement/**").hasRole("Supplier")
            .requestMatchers("/return/**").hasRole("Supplier")
            .requestMatchers("/invoice/**").hasRole("Supplier")
            .anyRequest().authenticated()
        )
        .sessionManagement(sessionManager->
            sessionManager
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authProvider)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
    }

    @Bean
    public CorsConfigurationSource corsConfiguration() {
        CorsConfiguration config = new CorsConfiguration();
        // origen permitido
        config.setAllowedOrigins(List.of("http://127.0.0.1:5500"));
        // metodos permitidos
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        // cabeceras/headers permitidos
        config.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);// rutas a las que aplica
        return source;
    }
    
}
