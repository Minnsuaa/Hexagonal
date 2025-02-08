package com.example.hexagonal.application.port.in;

import com.example.hexagonal.infrastructure.adapter.in.dto.request.UserRequest;
import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;

public interface LoginUseCase {
    TokenResponse login(UserRequest request);
}