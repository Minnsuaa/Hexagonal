package com.example.hexagonal.application.port.in;

import com.example.hexagonal.infrastructure.adapter.in.dto.request.UserRequest;

public interface SignupUseCase {
    void signup(UserRequest request);
}