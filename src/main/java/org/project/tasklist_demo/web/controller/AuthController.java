package org.project.tasklist_demo.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.project.tasklist_demo.domain.user.User;
import org.project.tasklist_demo.service.AuthService;
import org.project.tasklist_demo.service.UserService;
import org.project.tasklist_demo.web.dto.auth.JwtRequest;
import org.project.tasklist_demo.web.dto.auth.JwtResponse;
import org.project.tasklist_demo.web.dto.user.UserDto;
import org.project.tasklist_demo.web.dto.validation.OnCreate;
import org.project.tasklist_demo.web.mappers.UserMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(name = "Auth Controller", description = "Auth API")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/login")
    public JwtResponse login(@Validated
                             @RequestBody final JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class)
                            @RequestBody final UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody final String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
