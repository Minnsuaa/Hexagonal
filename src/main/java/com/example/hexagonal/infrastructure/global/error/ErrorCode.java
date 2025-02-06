package com.example.hexagonal.infrastructure.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),

    ALREADY_USER_EXIST(HttpStatus.CONFLICT, "User already exists");

    private final HttpStatus status;
    private final String message;
}
