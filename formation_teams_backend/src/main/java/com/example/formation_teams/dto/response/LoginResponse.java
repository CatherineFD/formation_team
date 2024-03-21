package com.example.formation_teams.dto.response;

import com.example.formation_teams.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String position;

    public static LoginResponse fromUser(User user) {
        return LoginResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .phone(user.getPhone())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .position(user.getPosition())
                .build();
    }
}
