package com.example.formation_teams.dto.request;

import com.example.formation_teams.model.AnswerTestValue;
import com.example.formation_teams.model.AnswerTestValueKey;
import com.example.formation_teams.model.PassingTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerTestValueRequest {

    private int number;

    private int answer;


    public AnswerTestValue toAnswer(Long id, PassingTest passingTest) {
        AnswerTestValue answerTestValue = new AnswerTestValue();
        AnswerTestValueKey answerTestValueKey = new AnswerTestValueKey();

        answerTestValueKey.setPassingId(id);
        answerTestValueKey.setQuestionId(this.number);

        answerTestValue.setId(answerTestValueKey);
        answerTestValue.setAnswer(this.answer);

        answerTestValue.setPassingTest(passingTest);


        return answerTestValue;
    }
}
