package com.example.hexagonal.application.port.out;

import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;

public interface JwtPort {

    TokenResponse getTokens(String accountId);

}