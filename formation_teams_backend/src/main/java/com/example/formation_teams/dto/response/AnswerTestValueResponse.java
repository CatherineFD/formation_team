package com.example.formation_teams.dto.response;

import com.example.formation_teams.model.AnswerTestValue;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerTestValueResponse {

    private int question;

    private int answer;

    public static AnswerTestValueResponse fromAnswer(AnswerTestValue answerTestValue) {

        return builder()
                .question(answerTestValue.getId().getQuestionId())
                .answer(answerTestValue.getAnswer())
                .build();
    }
}
