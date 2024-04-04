package com.example.formation_teams.service;

import com.example.formation_teams.dto.request.PassingTestRequest;
import com.example.formation_teams.model.PassingTest;

public interface PassingTestService {

    PassingTest create(PassingTestRequest passingTestRequest);
}
