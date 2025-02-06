package com.example.hexagonal.domain.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private Long id;
    private String accountId;
    private String password;

}
