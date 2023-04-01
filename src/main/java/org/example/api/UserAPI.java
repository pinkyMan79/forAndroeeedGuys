package org.example.api;

import org.example.models.dto.user.UserRequest;
import org.example.models.dto.user.UserResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserAPI {

    @PostMapping("/register")
    UserResponse register(@RequestBody UserRequest request);

    @GetMapping("/login/{login}/{password}")
    UserResponse login(@PathVariable("login") String login, @PathVariable("password") String password);


}
