package com.example.hexagonal.application.service;

import com.example.hexagonal.application.port.in.LoginUseCase;
import com.example.hexagonal.application.port.out.JwtPort;
import com.example.hexagonal.application.port.out.UserPort;
import com.example.hexagonal.domain.exception.PasswordMisMatchException;
import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.infrastructure.adapter.in.dto.request.UserRequest;
import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    private final JwtPort jwtPort;
    private final UserPort userPort;

    @Override
    public TokenResponse login(UserRequest request) {
        User user = userPort.findByAccountId(request.getAccountId());
        if (!user.getPassword().equals(request.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        return jwtPort.getTokens(request.getAccountId());
    }

}