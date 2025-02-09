package com.example.hexagonal.application.service;

import com.example.hexagonal.application.port.in.LogoutUseCase;
import com.example.hexagonal.application.port.out.RefreshPort;
import com.example.hexagonal.application.port.out.SecurityPort;
import com.example.hexagonal.domain.model.RefreshToken;
import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.infrastructure.adapter.out.entity.RefreshTokenEntity;
import com.example.hexagonal.infrastructure.adapter.out.mapper.RefreshMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutUseCase {

    private final SecurityPort securityPort;
    private final RefreshPort refreshPort;
    private final RefreshMapper refreshMapper;

    @Transactional
    public void logout() {
        User user = securityPort.getCurrentUser();

        RefreshToken refreshToken = refreshPort.findRefreshTokenByAccountId(user.getAccountId());
        RefreshTokenEntity refreshTokenEntity = refreshMapper.toEntity(refreshToken);
        refreshPort.deleteToken(refreshTokenEntity);
    }

}