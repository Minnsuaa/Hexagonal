package com.example.hexagonal.application.service;

import com.example.hexagonal.application.port.in.LoginUseCase;
import com.example.hexagonal.application.port.out.JwtPort;
import com.example.hexagonal.application.port.out.SecurityPort;
import com.example.hexagonal.application.port.out.UserPort;
import com.example.hexagonal.domain.exception.PasswordMisMatchException;
import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.infrastructure.adapter.in.dto.request.AuthRequest;
import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {

    private final JwtPort jwtPort;
    private final UserPort userPort;
    private final SecurityPort securityPort;

    @Override
    @Transactional
    public TokenResponse login(AuthRequest request) {
        User user = userPort.findByAccountId(request.getAccountId());
        if (!securityPort.isPasswordMatch(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        return jwtPort.getTokens(request.getAccountId());
    }

}