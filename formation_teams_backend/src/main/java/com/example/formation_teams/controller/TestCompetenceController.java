package com.example.formation_teams.controller;

import com.example.formation_teams.dto.request.PassingTestRequest;
import com.example.formation_teams.model.PassingTest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test-competence")
public class TestCompetenceController {

    @PostMapping("/save-results")
    public ResponseEntity<?> saveResultsTestCompetence(@Valid @RequestBody PassingTestRequest passingTestRequest, Principal principal) {


        return null;
    }

}
