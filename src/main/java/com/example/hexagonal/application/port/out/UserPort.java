package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.model.User;

public interface UserPort {
    void save(User user);
    User findByAccountId(String accountId);
}