package com.example.hexagonal.application.service;

import com.example.hexagonal.application.port.in.SignupUseCase;
import com.example.hexagonal.application.port.out.SecurityPort;
import com.example.hexagonal.application.port.out.UserPort;
import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.infrastructure.adapter.in.dto.request.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService implements SignupUseCase {

    private final UserPort userPort;
    private final SecurityPort securityPort;

    @Override
    @Transactional
    public void signup(AuthRequest request) {
        User user = User.builder()
                .accountId(request.getAccountId())
                .password(securityPort.encodePassword(request.getPassword()))
                .build();

        userPort.save(user);
    }

}