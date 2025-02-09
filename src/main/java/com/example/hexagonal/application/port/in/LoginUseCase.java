package com.example.hexagonal.application.port.in;

import com.example.hexagonal.infrastructure.adapter.in.dto.request.AuthRequest;
import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;

public interface LoginUseCase {
    TokenResponse login(AuthRequest request);
}