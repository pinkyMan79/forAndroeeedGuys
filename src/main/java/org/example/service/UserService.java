package org.example.service;

import org.example.models.dto.user.UserRequest;
import org.example.models.dto.user.UserResponse;

public interface UserService {

    UserResponse doRegister(UserRequest request);

    UserResponse doLogin(String login, String password);

}
