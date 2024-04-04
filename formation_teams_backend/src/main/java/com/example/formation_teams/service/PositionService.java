package com.example.formation_teams.service;

import com.example.formation_teams.model.Position;

import java.util.List;

public interface PositionService {

    List<Position> findUserById(Long id);

    Position findById(Long id);
}
