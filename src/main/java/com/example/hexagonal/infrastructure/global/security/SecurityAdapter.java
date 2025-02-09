package com.example.hexagonal.infrastructure.global.security;

import com.example.hexagonal.application.port.out.SecurityPort;
import com.example.hexagonal.domain.exception.UserNotFoundException;
import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.infrastructure.adapter.out.mapper.UserMapper;
import com.example.hexagonal.infrastructure.adapter.out.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityAdapter implements SecurityPort {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean isPasswordMatch(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }

    @Override
    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByAccountId(accountId)
                .map(userMapper::toUser)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}