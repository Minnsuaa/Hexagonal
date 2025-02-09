package com.example.hexagonal.infrastructure.adapter.out;

import com.example.hexagonal.application.port.out.RefreshPort;
import com.example.hexagonal.domain.model.RefreshToken;
import com.example.hexagonal.infrastructure.adapter.out.entity.RefreshTokenEntity;
import com.example.hexagonal.infrastructure.adapter.out.mapper.RefreshMapper;
import com.example.hexagonal.infrastructure.adapter.out.repository.RefreshTokenRepository;
import com.example.hexagonal.infrastructure.global.exception.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefreshPersistenceAdapter implements RefreshPort {

    private final RefreshTokenRepository refreshTokenRepository;
    private final RefreshMapper refreshMapper;

    @Override
    public RefreshToken findRefreshTokenByAccountId(String accountId) {
        return refreshTokenRepository.findByAccountId(accountId)
                .map(refreshMapper::toDomain)
                .orElseThrow(() -> InvalidTokenException.EXCEPTION);
    }

    @Override
    public void deleteToken(RefreshTokenEntity refreshToken) {
        refreshTokenRepository.delete(refreshToken);
    }

    @Override
    public RefreshToken findRefreshToken(String token) {
        return refreshTokenRepository.findByRefreshToken(token)
                .map(refreshMapper::toDomain)
                .orElseThrow(() -> InvalidTokenException.EXCEPTION);
    }

}