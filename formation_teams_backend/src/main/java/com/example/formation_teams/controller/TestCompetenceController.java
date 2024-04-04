package com.example.formation_teams.controller;

import com.example.formation_teams.dto.request.AnswerTestValueRequest;
import com.example.formation_teams.dto.request.PassingTestRequest;
import com.example.formation_teams.model.PassingTest;
import com.example.formation_teams.model.Position;
import com.example.formation_teams.model.User;
import com.example.formation_teams.service.PassingTestService;
import com.example.formation_teams.service.PositionService;
import com.example.formation_teams.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test-competence")
public class TestCompetenceController {

    private final UserService userService;
    private final PositionService positionService;
    private final PassingTestService passingTestService;

    @PostMapping("/save-results")
    public ResponseEntity<?> saveResultsTestCompetence(@Valid @RequestBody List<AnswerTestValueRequest> answersTestValueRequest, Principal principal, @RequestParam long positionId) {

        User user = userService.getByEmail(principal.getName());
        Position position = positionService.findById(positionId);

        PassingTest passingTest = passingTestService.create(new PassingTestRequest(answersTestValueRequest), user, position);
        return ResponseEntity.ok().build();
    }

}
