package com.example.formation_teams.service.impl;

import com.example.formation_teams.dto.request.PassingTestRequest;
import com.example.formation_teams.model.AnswerTestValue;
import com.example.formation_teams.model.PassingTest;
import com.example.formation_teams.model.Position;
import com.example.formation_teams.model.User;
import com.example.formation_teams.repo.PassingTestRepo;
import com.example.formation_teams.service.PassingTestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PassingTestServiceImpl implements PassingTestService {

    private PassingTestRepo passingTestRepo;


    @Override
    public PassingTest create(PassingTestRequest passingTestRequest, User user, Position position) {

//        PassingTest passingTest = passingTestRequest.toPassingTest();
        PassingTest passingTest = passingTestRepo.save(new PassingTest());

        passingTest = passingTestRequest.toPassingTest(passingTest.getPassingId());
        passingTest.setPosition(position);
        passingTest.setUser(user);
        passingTest.setResult(countResultQuestions(passingTest.getAnswers()));

        int countNumberQuestions = passingTest.getAnswers().size();
        passingTest.setNumberQuestion(countNumberQuestions);

        Date currestDate = new Date();
        passingTest.setDatePassing(currestDate);
        return passingTestRepo.save(passingTest);
    }

    private int countResultQuestions(List<AnswerTestValue> answersTestValue) {
        int countNumber = 0;

        for (AnswerTestValue answer: answersTestValue) {
            countNumber += answer.getAnswer();
        }

        return countNumber;
    }


}
