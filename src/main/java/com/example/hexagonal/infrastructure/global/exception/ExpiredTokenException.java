package com.example.hexagonal.infrastructure.global.exception;

import com.example.hexagonal.infrastructure.global.error.ErrorCode;
import com.example.hexagonal.infrastructure.global.error.HexagonalException;

public class ExpiredTokenException extends HexagonalException {

    public static final HexagonalException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }

}