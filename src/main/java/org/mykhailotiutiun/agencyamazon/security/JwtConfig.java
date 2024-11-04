package org.mykhailotiutiun.agencyamazon.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtTokenValidator jwtTokenValidator){
        return new JwtAuthenticationFilter(jwtTokenValidator);
    }

    @Bean
    public JwtTokenValidatorImpl jwtTokenValidator(@Value("${jwt.secret}") String secret){
        return new JwtTokenValidatorImpl(secret);
    }
}
