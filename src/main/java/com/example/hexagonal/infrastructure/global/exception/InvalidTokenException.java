package com.example.hexagonal.infrastructure.global.exception;

import com.example.hexagonal.infrastructure.global.error.ErrorCode;
import com.example.hexagonal.infrastructure.global.error.HexagonalException;

public class InvalidTokenException extends HexagonalException {

    public static final HexagonalException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }

}