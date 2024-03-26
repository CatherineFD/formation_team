package com.example.formation_teams.service.impl;

import com.example.formation_teams.model.Position;
import com.example.formation_teams.repo.PositionRepo;
import com.example.formation_teams.service.PositionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Setter
public class PositionServiceImpl implements PositionService {

    private PositionRepo positionRepo;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<Position> findUserById(Long id) {
        log.debug("Getting positions for user");
        return positionRepo.findByUsersUserId(id);
    }
}
