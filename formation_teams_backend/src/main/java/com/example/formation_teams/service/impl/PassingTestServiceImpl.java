package com.example.formation_teams.service.impl;

import com.example.formation_teams.dto.request.PassingTestRequest;
import com.example.formation_teams.dto.response.AnswerTestValueResponse;
import com.example.formation_teams.dto.response.CompetenceTestResponse;
import com.example.formation_teams.dto.response.PassingTestResponse;
import com.example.formation_teams.model.*;
import com.example.formation_teams.repo.AppointTestRepo;
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
    private AppointTestRepo appointTestRepo;


    @Override
    public PassingTest create(PassingTestRequest passingTestRequest, User user, Position position) {
        PassingTest passingTest = passingTestRepo.save(new PassingTest());

        for(AppointTest appointTest: user.getAppointTests()) {
           if (appointTest.getId().getPositionId() == position.getPositionId()) {
               appointTest.setPassed(true);
               appointTestRepo.save(appointTest);
           }
        }

        passingTest = passingTestRequest.toPassingTest(passingTest.getPassingId());
        passingTest.setPosition(position);
        passingTest.setUser(user);
        passingTest.setResult(countResultQuestions(passingTest.getAnswers()));

        int countNumberQuestions = passingTest.getAnswers().size();
        passingTest.setNumberQuestions(countNumberQuestions);

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
