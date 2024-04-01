package com.example.formation_teams.controller;

import com.example.formation_teams.dto.request.PositionRequest;
import com.example.formation_teams.dto.request.UserRequest;
import com.example.formation_teams.dto.response.CompetenceResponse;
import com.example.formation_teams.dto.response.LoginResponse;
import com.example.formation_teams.dto.response.PositionNameResponse;
import com.example.formation_teams.dto.response.UserResponse;
import com.example.formation_teams.model.AppointTest;
import com.example.formation_teams.model.Competence;
import com.example.formation_teams.model.Position;
import com.example.formation_teams.model.User;
import com.example.formation_teams.service.AppointTestService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private final PositionService positionService;
    private final AppointTestService appointTestService;

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
    public ResponseEntity<?> appointTest(@PathVariable Long id, @RequestParam long positionId) {

        User user = userService.getById(id);

        boolean isAppoint = false;
        for (AppointTest appointTest: user.getAppointTests()) {
             if (appointTest.getId().getPositionId() == positionId && !appointTest.isPassed()) {
               isAppoint = true;
               break;
            }
        }
        if(!isAppoint) {
            appointTestService.appointTest(user, positionId);
            user = userService.getById(id);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(UserResponse.fromUser(user));
    }

    @GetMapping("user/test-competence")
    public ResponseEntity<?> getTestById(@RequestParam long positionId, Principal principal) {

        User user = userService.getByEmail(principal.getName());
        List<Competence> competencies = new ArrayList<>();

        boolean isAppoint = false;
        for (AppointTest appointTest: user.getAppointTests()) {
            if(appointTest.getId().getPositionId() == positionId) {
                isAppoint = true;
                break;
            }
        }

        if (isAppoint) {
            competencies = userService.getQuestionTest(positionId);
        }

        return ResponseEntity.ok(competencies.stream().map(u -> CompetenceResponse.fromCompetence(u)).collect(Collectors.toList()));

    }

}
