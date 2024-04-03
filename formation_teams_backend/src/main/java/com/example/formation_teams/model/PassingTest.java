package com.example.formation_teams.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="passing_test")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PassingTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passingId;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="users")
    @MapsId("userId")
    private User userId;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="positions")
    @MapsId("positionId")
    private Position position;


    private Timestamp datePassing;

    private int numberQuestion;

    private int result;
}
