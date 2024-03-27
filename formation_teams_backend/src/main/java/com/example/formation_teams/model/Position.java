package com.example.formation_teams.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="positions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long positionId;

    private String position;


    @ManyToMany
    @JoinTable(name = "test_value",
            joinColumns = @JoinColumn(name = "position_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id"))
    private List<Competence> competences;

    @ManyToMany(mappedBy = "positions")
    private List<User> users;
}
