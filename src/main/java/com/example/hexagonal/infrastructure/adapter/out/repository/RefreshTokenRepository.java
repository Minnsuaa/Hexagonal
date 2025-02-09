package com.example.hexagonal.infrastructure.adapter.out.repository;

import com.example.hexagonal.infrastructure.adapter.out.entity.RefreshTokenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, String> {

    Optional<RefreshTokenEntity> findByAccountId(String accountId);

    Optional<RefreshTokenEntity> findByRefreshToken(String token);

}