package com.example.hexagonal.infrastructure.global.security;

import com.example.hexagonal.application.port.out.SecurityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityAdapter implements SecurityPort {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean isPasswordMatch(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }

}