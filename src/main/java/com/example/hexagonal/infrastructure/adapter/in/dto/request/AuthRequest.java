package com.example.hexagonal.infrastructure.adapter.in.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthRequest {

    @NotBlank
    @Size(min = 8, max = 20)
    private String accountId;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

}