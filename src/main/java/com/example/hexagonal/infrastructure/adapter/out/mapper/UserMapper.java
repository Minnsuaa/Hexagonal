package com.example.hexagonal.infrastructure.adapter.out.mapper;

import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.infrastructure.adapter.out.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(User user) {
        return UserEntity.builder()
                .accountId(user.getAccountId())
                .password(user.getPassword())
                .build();
    }

}
