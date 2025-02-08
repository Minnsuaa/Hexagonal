package com.example.hexagonal.domain.exception;

import com.example.hexagonal.infrastructure.global.error.ErrorCode;
import com.example.hexagonal.infrastructure.global.error.HexagonalException;

public class PasswordMisMatchException extends HexagonalException {

    public static final HexagonalException EXCEPTION = new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }

}