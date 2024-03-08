package com.example.formation_teams.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;


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


















}
