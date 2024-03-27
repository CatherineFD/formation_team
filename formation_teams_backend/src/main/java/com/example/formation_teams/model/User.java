package com.example.formation_teams.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email(message = "Provide valid email")
    private String email;

    private String password;

    private String firstName;

    private String lastName;
    private String position;

    @Pattern(regexp = "^((8|\\+7|\\+1|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Phone must be '+{0}(000)000-00-00'")
    private String phone;

    @Enumerated(EnumType.STRING)
    private SystemRole systemRole;

    @ManyToMany
    @JoinTable(name="appoint_test",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="position_id"))
    List<Position> positions;

    @OneToMany(mappedBy = "user")
    List<AppointTest> appointTests;

    //в пользователя можно добавить общий результат и пройден тест или нет

    //результат созраняем в сущность resultCompetence
}
