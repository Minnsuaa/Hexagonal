package com.example.hexagonal.application.service;

import com.example.hexagonal.application.port.in.SignupUseCase;
import com.example.hexagonal.application.port.out.UserPort;
import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.infrastructure.adapter.in.dto.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService implements SignupUseCase {

    private final UserPort userPort;

    @Override
    public void signup(UserRequest request) {
        User user = User.builder()
                .accountId(request.getAccountId())
                .password(request.getPassword())
                .build();

        userPort.save(user);
    }

}
