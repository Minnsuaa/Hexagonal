package com.example.hexagonal.infrastructure.adapter.in.dto.response;

import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
public record TokenResponse(String accessToken, String refreshToken, ZonedDateTime accessExpiredAt, ZonedDateTime refreshExpiredAt) {
}