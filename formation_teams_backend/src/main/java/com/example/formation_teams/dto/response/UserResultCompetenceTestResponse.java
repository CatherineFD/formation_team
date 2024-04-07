package com.example.formation_teams.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class UserResultCompetenceTestResponse {

    private String name;

    private List<CompetenceTestResponse> competencies;



}
