package com.example.hexagonal.infrastructure.adapter.out.mapper;

import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.infrastructure.adapter.out.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .accountId(user.getAccountId())
                .password(user.getPassword())
                .build();
    }

    public User toUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .accountId(userEntity.getAccountId())
                .password(userEntity.getPassword())
                .build();
    }

}