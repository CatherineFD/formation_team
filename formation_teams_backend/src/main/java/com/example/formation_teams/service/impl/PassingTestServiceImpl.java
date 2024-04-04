package com.example.formation_teams.service.impl;

import com.example.formation_teams.dto.request.PassingTestRequest;
import com.example.formation_teams.model.PassingTest;
import com.example.formation_teams.repo.PassingTestRepo;
import com.example.formation_teams.service.PassingTestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PassingTestServiceImpl implements PassingTestService {

    private PassingTestRepo passingTestRepo;


    @Override
    public PassingTest create(PassingTestRequest passingTestRequest) {


        PassingTest passingTest = createPassing(passingTestRequest);
        return null;
    }

    public PassingTest createPassing(PassingTestRequest passingTestRequest) {

        PassingTest passingTest = new PassingTest();

        passingTest.setAnswers(passingTestRequest.getAnswers());
        return null;
    }
}
