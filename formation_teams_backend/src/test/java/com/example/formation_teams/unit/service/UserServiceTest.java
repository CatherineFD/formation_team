package com.example.formation_teams.unit.service;

import com.example.formation_teams.dto.request.UserRequest;
import com.example.formation_teams.exceptions.NotFoundException;
import com.example.formation_teams.model.User;
import com.example.formation_teams.repo.UserRepo;
import com.example.formation_teams.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    User testUser;

    UserRequest userRegDto;

    @BeforeEach
    public void setUp() {
        testUser = User.builder()
                .id(1L)
                .email("email@mail.com")
                .password("somepassword")
                .firstName("firstName")
                .lastName("lastname")
                .build();

        userRegDto = UserRequest.builder()
                .email(testUser.getEmail())
                .password(testUser.getPassword())
                .firstName(testUser.getFirstName())
                .lastName(testUser.getLastName())
                .build();
    }

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    UserServiceImpl sut;

    @Test
    public void givenUserRegistrationDTO_whenToUser_AllEquals() {
        User user =userRegDto.toUser();

        assertAll(
                () -> {
                    assertEquals(user.getEmail(), userRegDto.getEmail());
                    assertEquals(user.getPassword(), userRegDto.getPassword());
                    assertEquals(user.getFirstName(), userRegDto.getFirstName());
                    assertEquals(user.getLastName(), userRegDto.getLastName());
                });
    }

    @Test
    public void getByEmail_whenValidEmail_thenUserShouldBeFound() {
        when(userRepo.findByEmail(testUser.getEmail())).thenReturn(Optional.of(testUser));

        String email =testUser.getEmail();
        User user =sut.getByEmail(email);
        assertEquals(user.getEmail(), email);
    }


    @Test
    public void getByEmail_whenInvalidEmail_thenUserNotShouldBeFound() {
        when(userRepo.findByEmail(any())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> sut.getByEmail(testUser.getEmail()));
    }

    @Test
    public void findById_whenValidEmail_thenUserShouldBeFound() {
        when(userRepo.findById(testUser.getId())).thenReturn(Optional.of(testUser));

        Long id = testUser.getId();
        User user = sut.getById(id);
        assertEquals(user.getId(), id);
    }




}
