package com.example.hexagonal.infrastructure.adapter.in;

import com.example.hexagonal.application.port.in.SignupUseCase;
import com.example.hexagonal.infrastructure.adapter.in.dto.request.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SignupUseCase signupUseCase;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid UserRequest userRequest) {
        signupUseCase.signup(userRequest);
    }

}