package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.model.User;

public interface SecurityPort {

    String encodePassword(String password);

    boolean isPasswordMatch(String password, String encodedPassword);

    User getCurrentUser();

}