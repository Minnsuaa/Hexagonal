package com.example.hexagonal.application.port.in;

import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;

public interface ReissueUseCase {
    TokenResponse reissue(String refreshToken);
}