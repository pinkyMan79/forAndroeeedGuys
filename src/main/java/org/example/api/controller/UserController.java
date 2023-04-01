package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.UserAPI;
import org.example.models.dto.user.UserRequest;
import org.example.models.dto.user.UserResponse;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserAPI {

    private final UserService service;

    @Override
    public UserResponse register(UserRequest request) {
        return service.doRegister(request);
    }

    @Override
    public UserResponse login(String login, String password) {
        return service.doLogin(login, password);
    }
}
