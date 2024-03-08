package com.example.formation_teams.service;

import com.example.formation_teams.dto.request.UserRequest;
import com.example.formation_teams.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User create(UserRequest user);
}
