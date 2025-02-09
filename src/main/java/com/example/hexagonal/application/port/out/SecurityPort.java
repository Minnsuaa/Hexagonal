package com.example.hexagonal.application.port.out;

public interface SecurityPort {
    String encodePassword(String password);
    boolean isPasswordMatch(String password, String encodedPassword);
}