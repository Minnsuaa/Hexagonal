package com.example.hexagonal.application.port.out;

public interface JwtParserPort {
    String parseToken(String bearerToken);
}