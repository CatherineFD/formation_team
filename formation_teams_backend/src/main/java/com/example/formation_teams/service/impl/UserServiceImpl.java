package com.example.formation_teams.service.impl;


import com.example.formation_teams.dto.request.UserRequest;
import com.example.formation_teams.exceptions.AlreadyExistsException;
import com.example.formation_teams.model.User;
import com.example.formation_teams.repo.UserRepo;
import com.example.formation_teams.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
@Setter
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
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
}
