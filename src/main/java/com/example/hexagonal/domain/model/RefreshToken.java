package com.example.hexagonal.domain.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RefreshToken {

    private String accountId;
    private String refreshToken;
    private Long ttl;

}