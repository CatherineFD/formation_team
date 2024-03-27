package com.example.formation_teams.service.impl;

import com.example.formation_teams.model.AppointTest;
import com.example.formation_teams.model.AppointTestKey;
import com.example.formation_teams.model.User;
import com.example.formation_teams.repo.AppointTestRepo;
import com.example.formation_teams.service.AppointTestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointTestServiceImpl implements AppointTestService {
    private final AppointTestRepo appointTestRepo;


    @Override
    public AppointTest appointTest(User user, long positionId) {
        AppointTestKey appointTestKey = new AppointTestKey(user.getId(), positionId);
        AppointTest appointTest = new AppointTest(appointTestKey, false, user);

        return appointTestRepo.save(appointTest);
    }
}
