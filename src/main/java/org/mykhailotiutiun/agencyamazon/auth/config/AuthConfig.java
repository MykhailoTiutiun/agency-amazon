package org.mykhailotiutiun.agencyamazon.auth.config;

import org.mykhailotiutiun.agencyamazon.auth.AuthServiceImpl;
import org.mykhailotiutiun.agencyamazon.auth.JwtTokenGenerator;
import org.mykhailotiutiun.agencyamazon.auth.PasswordEncoder;
import org.mykhailotiutiun.agencyamazon.auth.UserRepository;
import org.mykhailotiutiun.agencyamazon.auth.encoder.PasswordEncoderImpl;
import org.mykhailotiutiun.agencyamazon.auth.jwt.JwtTokenGeneratorImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AuthConfig {

    @Bean
    public AuthServiceImpl authService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenGenerator jwtTokenGenerator){
        return new AuthServiceImpl(userRepository, passwordEncoder, jwtTokenGenerator);
    }

    @Bean
    public PasswordEncoderImpl passwordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder){
        return new PasswordEncoderImpl(bCryptPasswordEncoder);
    }

    @Bean
    public JwtTokenGeneratorImpl jwtTokenGenerator(@Value("${jwt.secret}") String secret){
        return new JwtTokenGeneratorImpl(secret);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
