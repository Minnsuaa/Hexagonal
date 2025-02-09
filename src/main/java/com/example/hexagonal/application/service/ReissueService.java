package com.example.hexagonal.application.service;

import com.example.hexagonal.application.port.in.ReissueUseCase;
import com.example.hexagonal.application.port.out.JwtPort;
import com.example.hexagonal.application.port.out.RefreshPort;
import com.example.hexagonal.domain.model.RefreshToken;
import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;
import com.example.hexagonal.infrastructure.adapter.out.mapper.RefreshMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReissueService implements ReissueUseCase {

    private final RefreshPort refreshPort;
    private final RefreshMapper refreshMapper;
    private final JwtPort jwtPort;

    @Override
    public TokenResponse reissue(String refreshToken) {
        RefreshToken refresh = refreshPort.findRefreshToken(refreshToken);
        String accountId = refresh.getAccountId();
        refreshPort.deleteToken(refreshMapper.toEntity(refresh));

        return jwtPort.getTokens(accountId);
    }

}