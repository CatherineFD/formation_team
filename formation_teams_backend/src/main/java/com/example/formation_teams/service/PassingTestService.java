package com.example.formation_teams.service;

import com.example.formation_teams.dto.request.PassingTestRequest;
import com.example.formation_teams.dto.response.PassingTestResponse;
import com.example.formation_teams.model.PassingTest;
import com.example.formation_teams.model.Position;
import com.example.formation_teams.model.User;

public interface PassingTestService {

    PassingTest create(PassingTestRequest passingTestRequest, User user, Position position);
}
