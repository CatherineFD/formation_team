package com.example.formation_teams.controller;

import com.example.formation_teams.dto.request.PositionRequest;
import com.example.formation_teams.dto.request.UserRequest;
import com.example.formation_teams.dto.response.LoginResponse;
import com.example.formation_teams.dto.response.PositionNameResponse;
import com.example.formation_teams.dto.response.UserResponse;
import com.example.formation_teams.model.AppointTest;
import com.example.formation_teams.model.Position;
import com.example.formation_teams.model.User;
import com.example.formation_teams.service.PositionService;
import com.example.formation_teams.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private final PositionService positionService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login")
    public ResponseEntity<?> getIdByEmail(Principal principal) {

        if (principal != null)
        {
            User user = userService.getByEmail(principal.getName());
            return ResponseEntity.ok(LoginResponse.fromUser(user));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequest user) {
        User newUser = userService.create(user);
        log.debug("Creating user {}", user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.fromUser(newUser));

    }

    @GetMapping("/all-users")
    public ResponseEntity<List<UserResponse>> getByAll() {
        List<User> users = userService.findAll();

        return ResponseEntity.ok(users.stream().map(u -> UserResponse.fromUser(u)).collect(Collectors.toList()));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id, Principal principal) {

        var requestedUser = userService.getById(id);
        var requestingUser = userService.getByEmail(principal.getName());

        var response = UserResponse.fromUser(requestedUser);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/user/{id}/appoint-test")
    public ResponseEntity<?> appointTest(@PathVariable Long id, Principal principal, @RequestParam long positionId) {

//        var requestedPosition = positionService.findUserById(id);
        User user = userService.getById(id);

        boolean isAppoint = false;
        for (AppointTest appointTest: user.getAppointTests()) {
             if (appointTest.getId().getPositionId() == positionId && !appointTest.isPassed()) {
               isAppoint = true;
            }
        }
        if(!isAppoint) {
            user = userService.addPositionUser(id, positionId);
        }


//        var response = PositionNameResponse.fromPositionName(requestedPosition);

//        создаю сервис, который отвечает за позиции
        // должен быть метод на вход - пользователя и позицую, которую нужно добавить
        //для пользователя я получаю позиции которые назначены, добавляю позиции, которые нужно добавить
        //для пользователя вызываю метод save (репозиторий)
        //измения будут отображены в базе
//        ResponseEntity.ok(requestedPosition.stream().map(u -> PositionNameResponse.fromPositionName(u)).collect(Collectors.toList()));
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserResponse.fromUser(user));
    }

}
