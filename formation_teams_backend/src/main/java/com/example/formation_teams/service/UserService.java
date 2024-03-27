package com.example.formation_teams.service;

import com.example.formation_teams.dto.request.UserRequest;
import com.example.formation_teams.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User create(UserRequest user);

    User getByEmail(String email);

    List<User> findAll();

    User getById(long id);

    User addPositionUser(Long idUser, Long idPosition);
}
