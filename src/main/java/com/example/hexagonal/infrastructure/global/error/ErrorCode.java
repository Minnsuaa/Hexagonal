package com.example.hexagonal.infrastructure.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),

    ALREADY_USER_EXIST(CONFLICT, "User already exists"),
    USER_NOT_FOUND(NOT_FOUND, "User Not Found"),
    PASSWORD_MISMATCH(UNAUTHORIZED, "Password Mismatch"),

    EXPIRED_TOKEN(UNAUTHORIZED, "Expired Token"),
    INVALID_TOKEN(UNAUTHORIZED, "Invalid Token");

    private final HttpStatus status;
    private final String message;
}