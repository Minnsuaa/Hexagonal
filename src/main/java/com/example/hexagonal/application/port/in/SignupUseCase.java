package com.example.hexagonal.application.port.in;

import com.example.hexagonal.infrastructure.adapter.in.dto.request.AuthRequest;

public interface SignupUseCase {
    void signup(AuthRequest request);
}