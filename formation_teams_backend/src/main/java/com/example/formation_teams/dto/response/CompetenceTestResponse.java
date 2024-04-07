package com.example.formation_teams.dto.response;


import com.example.formation_teams.model.Competence;
import com.example.formation_teams.model.PassingTest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CompetenceTestResponse {

    private String name;

    private List<AnswerTestValueResponse> answers;

//    public static CompetenceTestResponse fromCompetenceTest(PassingTest passingTest) {
//        return builder()
//                .name()
//    }

}
