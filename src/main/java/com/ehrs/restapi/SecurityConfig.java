package com.ehrs.restapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for simplicity
            .authorizeRequests()
            .requestMatchers("/ehrs_almeezan/api/v1/**").authenticated() // Protect API endpoints
            .and()
            .httpBasic(); // Use HTTP Basic Authentication

        return http.build();
    }
}
