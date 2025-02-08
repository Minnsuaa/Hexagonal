package com.example.hexagonal.infrastructure.adapter.out.repository;

import com.example.hexagonal.infrastructure.adapter.out.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    boolean existsByAccountId(String accountId);
    Optional<UserEntity> findByAccountId(String accountId);
}
