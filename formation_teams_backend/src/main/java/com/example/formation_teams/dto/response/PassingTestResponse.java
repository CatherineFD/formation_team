package com.example.formation_teams.dto.response;

import com.example.formation_teams.model.Competence;
import com.example.formation_teams.model.PassingTest;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PassingTestResponse {

    private String positionName;

    private List<CompetenceTestResponse> usersResult = new ArrayList<>();

    public static PassingTestResponse fromPassingTest(PassingTest passingTest) {
        PassingTestResponse passingTestResponse = new PassingTestResponse();
        passingTestResponse.setPositionName(passingTest.getPosition().getPosition());

        for (Competence competence : passingTest.getPosition().getCompetences()) {
            CompetenceTestResponse competenceTestResponse = new CompetenceTestResponse();
            competenceTestResponse.setName(competence.getCompetence());

            var answers = passingTest.getAnswers().stream()
                    .filter(c -> competence.getQuestions().contains(c.getId().getQuestionId()))
                    .map(AnswerTestValueResponse::fromAnswer).toList();

            competenceTestResponse.setAnswers(answers);
            passingTestResponse.getUsersResult().add(competenceTestResponse);

        }

        return passingTestResponse;
    }
}
