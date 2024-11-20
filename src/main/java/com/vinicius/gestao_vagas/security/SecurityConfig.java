package com.vinicius.gestao_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration -> Indica que essa classe é uma configuração que vai iniciar junto com a aplicação.
@Configuration
public class SecurityConfig {
    // @Bean -> Indica que esse método será sobrescrito pelo Spring
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
