package com.example.hexagonal.infrastructure.adapter.in;

import com.example.hexagonal.application.port.in.LoginUseCase;
import com.example.hexagonal.application.port.in.SignupUseCase;
import com.example.hexagonal.infrastructure.adapter.in.dto.request.UserRequest;
import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserWebAdapter {

    private final SignupUseCase signupUseCase;
    private final LoginUseCase loginUseCase;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid UserRequest userRequest) {
        signupUseCase.signup(userRequest);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserRequest userRequest) {
        return loginUseCase.login(userRequest);
    }

}