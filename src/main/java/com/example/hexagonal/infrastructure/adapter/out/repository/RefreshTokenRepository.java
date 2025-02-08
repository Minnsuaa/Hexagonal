package com.example.hexagonal.infrastructure.adapter.out.repository;

import com.example.hexagonal.infrastructure.adapter.out.entity.RefreshTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, String> {
}
