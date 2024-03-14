package com.example.formation_teams.controller;

import com.example.formation_teams.dto.request.UserRequest;
import com.example.formation_teams.dto.response.UserResponse;
import com.example.formation_teams.model.User;
import com.example.formation_teams.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseEntity<?> addTestResultToUser() {
        System.out.println("Login req");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequest user) {
        User newUser = userService.create(user);
        log.debug("Creating user {}", user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.fromUser(newUser));

    }

}
