package com.handroid.spring_ci_cd.controller;

import jakarta.servlet.ServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class UserController {

    @GetMapping("/users")
    @Secured({"ADMIN"})
    public String users(ServletRequest request, Authentication authentication) {

        return "admin@email.com";
    }

    @GetMapping("/users/super-admin")
    @Secured({"USER", "SUPER_ADMIN"})
    public String usersSuperAdmin(ServletRequest request, Authentication authentication) {

        return "super.admin@email.com";
    }
}
