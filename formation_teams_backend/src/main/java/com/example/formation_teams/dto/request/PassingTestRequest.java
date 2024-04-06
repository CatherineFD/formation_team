package com.example.formation_teams.dto.request;

import com.example.formation_teams.model.PassingTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassingTestRequest {

   private List<AnswerTestValueRequest> answers;

   public PassingTest toPassingTest(Long id) {

      PassingTest passingTest = new PassingTest();

      passingTest.setPassingId(id);
      passingTest.setAnswers(this.answers.stream().map(u -> u.toAnswer(id)).toList());

      return passingTest;
   }
}
