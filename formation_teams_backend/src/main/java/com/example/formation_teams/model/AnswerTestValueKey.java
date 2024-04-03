package com.example.formation_teams.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AnswerTestValueKey implements Serializable {

    @Column(name="passing_id", insertable=false, updatable=false)
    private int passingId;

    @Column(name="question_id", insertable=false, updatable=false)
    private int questionId;
}
