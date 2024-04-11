package com.example.formation_teams.service;

import com.example.formation_teams.model.AppointTest;
import com.example.formation_teams.model.Position;
import com.example.formation_teams.model.User;

public interface AppointTestService {

    AppointTest appointTest(User user, long positionId, Position position);
}
