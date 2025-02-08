package com.example.hexagonal.domain.exception;

import com.example.hexagonal.infrastructure.global.error.ErrorCode;
import com.example.hexagonal.infrastructure.global.error.HexagonalException;

public class UserNotFoundException extends HexagonalException {

    public static final HexagonalException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}