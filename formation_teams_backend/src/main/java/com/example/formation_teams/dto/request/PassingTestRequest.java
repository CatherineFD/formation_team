package com.example.formation_teams.dto.request;

import com.example.formation_teams.model.AnswerTestValue;
import com.example.formation_teams.model.AnswerTestValueKey;
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

}
