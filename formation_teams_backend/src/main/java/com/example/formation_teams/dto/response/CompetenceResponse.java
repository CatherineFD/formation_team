package com.example.formation_teams.dto.response;

import com.example.formation_teams.model.Competence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetenceResponse {
    private long id;

    private String nameCompetence;

    private List<Integer> questions;

    public static CompetenceResponse fromCompetence(Competence competence) {

        return builder()
                .id(competence.getCompetenceId())
                .nameCompetence(competence.getCompetence())
                .questions(competence.getQuestions())
                .build();
    }
}
