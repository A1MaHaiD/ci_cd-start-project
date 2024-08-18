package com.handroid.spring_ci_cd.service;

import com.handroid.spring_ci_cd.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final List<UserDto> users = new ArrayList<>();
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void setup() {
        users.add(
        UserDto.of(
                1L,
                "test@user",
                "$2a$10$l0nm2bpyynRf7UqPqOgDkuQx6/h0nvzmLlvwFEbZo75H6kmpAJXDm",
                true,
                true,
                true,
                true,
                List.of(new SimpleGrantedAuthority("ADMIN"))
        ));
    }

    @Override
    public UserDto loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(userDto -> userDto.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public void createUser(UserDetails user) {
        users.add((UserDto) user);
    }

    public List<UserDto> all() {
        return users;
    }
}
