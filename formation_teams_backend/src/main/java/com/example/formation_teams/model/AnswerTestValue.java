package com.example.formation_teams.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="answer_test_value")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerTestValue {

    @EmbeddedId
    private AnswerTestValueKey id;

    private int answer;

    @ManyToOne
    @JoinColumn(name="passing_id")
    @MapsId("passingId")
    private PassingTest passingTest;
}
