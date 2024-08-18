package com.handroid.spring_ci_cd.controller;

import com.handroid.spring_ci_cd.dto.UserDto;
import com.handroid.spring_ci_cd.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    @Secured({"ADMIN"})
    public List<UserDto> users() {
        log.info("/users invocation");
        return userService.all();
    }

    @PostMapping("/users")
    @Secured({"ADMIN", "SUPER_ADMIN"})
    public UserDto create(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return userDto;
    }
}
