package com.example.hexagonal.infrastructure.adapter.in;

import com.example.hexagonal.application.port.in.LoginUseCase;
import com.example.hexagonal.application.port.in.LogoutUseCase;
import com.example.hexagonal.application.port.in.ReissueUseCase;
import com.example.hexagonal.application.port.in.SignupUseCase;
import com.example.hexagonal.infrastructure.adapter.in.dto.request.AuthRequest;
import com.example.hexagonal.infrastructure.adapter.in.dto.request.TokenRequest;
import com.example.hexagonal.infrastructure.adapter.in.dto.response.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthWebAdapter {

    private final SignupUseCase signupUseCase;
    private final LoginUseCase loginUseCase;
    private final LogoutUseCase logoutUseCase;
    private final ReissueUseCase reissueUseCase;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid AuthRequest request) {
        signupUseCase.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid AuthRequest request) {
        return loginUseCase.login(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout() {
        logoutUseCase.logout();
    }

    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestBody TokenRequest request) {
        return reissueUseCase.reissue(request.refreshToken());
    }

}