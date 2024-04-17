package com.example.formation_teams.unit.service;

import com.example.formation_teams.model.PassingTest;
import org.junit.jupiter.api.BeforeEach;

public class PassingTestServiceTest {

    PassingTest passingTest;

    @BeforeEach
    public void setUp() {
        passingTest = PassingTest.builder()

                .build();
    }
}
