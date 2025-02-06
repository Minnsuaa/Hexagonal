package com.example.hexagonal.infrastructure.adapter.out.repository;

import com.example.hexagonal.infrastructure.adapter.out.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    boolean existsByAccountId(String accountId);
}
