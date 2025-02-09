package com.example.hexagonal.infrastructure.adapter.out.mapper;

import com.example.hexagonal.domain.model.RefreshToken;
import com.example.hexagonal.infrastructure.adapter.out.entity.RefreshTokenEntity;
import org.springframework.stereotype.Component;

@Component
public class RefreshMapper {

    public RefreshToken toDomain(RefreshTokenEntity entity) {
        return RefreshToken.builder()
                .accountId(entity.getAccountId())
                .refreshToken(entity.getRefreshToken())
                .ttl(entity.getTtl())
                .build();
    }

    public RefreshTokenEntity toEntity(RefreshToken domain) {
        return RefreshTokenEntity.builder()
                .accountId(domain.getAccountId())
                .refreshToken(domain.getRefreshToken())
                .ttl(domain.getTtl())
                .build();
    }

}