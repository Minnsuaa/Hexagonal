package com.example.hexagonal.infrastructure.adapter.out;

import com.example.hexagonal.application.port.out.UserPort;
import com.example.hexagonal.domain.exception.UserNotFoundException;
import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.infrastructure.adapter.out.entity.UserEntity;
import com.example.hexagonal.infrastructure.adapter.out.mapper.UserMapper;
import com.example.hexagonal.infrastructure.adapter.out.repository.UserRepository;
import com.example.hexagonal.infrastructure.global.error.ErrorCode;
import com.example.hexagonal.infrastructure.global.error.HexagonalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void save(User user) {
        if(userRepository.existsByAccountId(user.getAccountId())) {
            throw new HexagonalException(ErrorCode.ALREADY_USER_EXIST);
        }

        UserEntity userEntity = userMapper.toEntity(user);
        userRepository.save(userEntity);
    }

    @Override
    public User findByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId)
                .map(userMapper::toDomain)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}