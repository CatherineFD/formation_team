package com.example.formation_teams.dto.request;

import com.example.formation_teams.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRequest {

    @Email(message = "Provide valid email")
    @NotEmpty(message = "Provide a email")
    private String email;

    @NotNull(message = "Provide a password")
    private String password;

    @NotEmpty(message = "Provide a  first name")
    private String firstName;

    @NotEmpty(message = "Provide a  last name")
    private String lastName;

    @NotEmpty(message = "Provide a phone")
    @Pattern(regexp = "^((8|\\+7|\\+1|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Phone must be '+{0}(000)000-00-00'")
    private String phone;

    public User toUser() {
        User user = new User();

        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setPhone(this.phone);

        return user;
    }



}
