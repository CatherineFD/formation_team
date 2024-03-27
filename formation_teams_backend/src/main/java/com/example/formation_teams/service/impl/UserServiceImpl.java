package com.example.formation_teams.service.impl;


import com.example.formation_teams.dto.request.UserRequest;
import com.example.formation_teams.exceptions.AlreadyExistsException;
import com.example.formation_teams.exceptions.NotFoundException;
import com.example.formation_teams.model.Position;
import com.example.formation_teams.model.User;
import com.example.formation_teams.repo.PositionRepo;
import com.example.formation_teams.repo.UserRepo;
import com.example.formation_teams.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Setter
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private PositionRepo positionRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User create(UserRequest userRequest){

        userRequest.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));

        if(!isUserExistsByEmail(userRequest.getEmail())) {
            User savedUser = saveDefaultUser(userRequest);

            return savedUser;
        }
        else {
            log.debug("Already exists");
            throw new AlreadyExistsException(
                    "User with email " + userRequest.getEmail() + " already Exists"
            );
        }
    }

    private boolean isUserExistsByEmail(String email) {return userRepo.findByEmail(email).isPresent();}

    private User saveDefaultUser(UserRequest request) {
        User user = request.toUser();
        user.setPhone(request.getPhone());


        return userRepo.save(user);
    }

    @Override
    public User getByEmail(String email) {
        log.debug("Finding user by email {}", email);

        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            log.debug("User with email: {} found. User: {}", email, user.get());
            return user.get();
        } else log.debug("Not found");

        throw new NotFoundException("User with email" + email + "not found");
    }

    @Override
    public List<User> findAll() {
        log.debug("Getting all users");
        return userRepo.findAll();
    }

    @Override
    public User getById(long id) {
        log.debug("Finding user by id {}", id);

        Optional<User> userOpt = userRepo.findById(id);

        if(userOpt.isPresent()) {
            log.debug("User with id: {} found. User: {}", id, userOpt.get());

            User user = userOpt.get();
            return user;
        } else throw new NotFoundException("User with id " + id + " not found");

    }

    @Override
    public User addPositionUser(Long idUser, Long idPosition) {
        User user = userRepo.findById(idUser).orElse(null);

        if (user == null) {
            throw new NotFoundException("User with id " + idUser + " not found");
        }
        Position position = positionRepo.findById(idPosition).orElse(null);

        if (position == null) {
            throw new NotFoundException("Position with id " + idPosition + " not found");
        }

        user.getPositions().add(position);


        return userRepo.save(user);
    }


}
