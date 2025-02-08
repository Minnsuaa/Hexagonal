package com.example.hexagonal.infrastructure.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HexagonalException extends RuntimeException {

    private final ErrorCode errorCode;

}