package com.example.hexagonal.domain.exception;

import com.example.hexagonal.infrastructure.global.error.ErrorCode;
import com.example.hexagonal.infrastructure.global.error.HexagonalException;

public class AlreadyUserExistException extends HexagonalException {

    public static final HexagonalException EXCEPTION = new AlreadyUserExistException();

    private AlreadyUserExistException() {
        super(ErrorCode.ALREADY_USER_EXIST);
    }

}
