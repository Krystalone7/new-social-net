package com.biom.controller;

import com.biom.dto.UserCreateDto;
import com.biom.dto.UserDto;
import com.biom.security.data.Authorization;
import com.biom.security.data.Token;
import com.biom.service.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final Auth auth;

    @PostMapping("/registration")
    public UserDto createUser(UserCreateDto userCreateDto) {
        return auth.registration(userCreateDto);
    }

    @PostMapping("/auth")
    public String signIn(Authorization authorization) {
        Token token = auth.signIn(authorization);

        return "Вы успешно вошли в систему!";
    }
}