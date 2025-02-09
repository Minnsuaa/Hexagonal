package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.model.RefreshToken;
import com.example.hexagonal.infrastructure.adapter.out.entity.RefreshTokenEntity;

public interface RefreshPort {

    RefreshToken findRefreshTokenByAccountId(String accountId);

    void deleteToken(RefreshTokenEntity refreshToken);

    RefreshToken findRefreshToken(String refreshToken);

}