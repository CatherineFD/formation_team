package com.example.formation_teams.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="position_id")
    private Position position;

    private Date datePassing;

//    private int numberQuestions;
//
//    private int result;

    @OneToMany(mappedBy = "passingTest", cascade = CascadeType.ALL)
    private List<AnswerTestValue> answers;
}
