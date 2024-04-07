package com.example.formation_teams.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PassingTestResponse {
    List<UserResultCompetenceTestResponse> usersResult;
}
