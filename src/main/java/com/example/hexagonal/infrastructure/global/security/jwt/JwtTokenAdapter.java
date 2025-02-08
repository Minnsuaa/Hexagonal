package com.example.hexagonal.infrastructure.global.security.jwt;

import com.example.hexagonal.application.port.out.JwtPort;
import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;
import com.example.hexagonal.infrastructure.adapter.out.entity.RefreshTokenEntity;
import com.example.hexagonal.infrastructure.adapter.out.repository.RefreshTokenRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenAdapter implements JwtPort {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    private SecretKeySpec secretKeySpec;

    @PostConstruct
    public void initSecretKeySpec() {
        this.secretKeySpec = new SecretKeySpec(jwtProperties.getSecretKey().getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }

    private String generateToken(String accountId, String type, Long exp) {
        return Jwts.builder()
                .signWith(secretKeySpec)
                .setSubject(accountId)
                .setHeaderParam("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    private String generateAccess(String accountId) {
        return generateToken(accountId, "access", jwtProperties.getAccessExp());
    }

    private String generateRefresh(String accountId) {
        String refresh = generateToken(accountId, "refresh", jwtProperties.getRefreshExp());

        refreshTokenRepository.save(RefreshTokenEntity.builder()
                .accountId(accountId)
                .refreshToken(refresh)
                .ttl(jwtProperties.getRefreshExp())
                .build());

        return refresh;
    }

    @Override
    public TokenResponse getTokens(String accountId) {
        return TokenResponse.builder()
                .accessToken(generateAccess(accountId))
                .refreshToken(generateRefresh(accountId))
                .accessExpiredAt(ZonedDateTime.now(ZoneId.of("Asia/Seoul")).plusSeconds(jwtProperties.getAccessExp()))
                .refreshExpiredAt(ZonedDateTime.now(ZoneId.of("Asia/Seoul")).plusSeconds(jwtProperties.getRefreshExp()))
                .build();

    }

}