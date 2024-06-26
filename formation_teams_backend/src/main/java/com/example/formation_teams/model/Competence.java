package com.example.formation_teams.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="competencies")
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long competenceId;

    private String competence;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "question_competence",
            joinColumns = @JoinColumn(name = "competence_id"))
    @Column(name = "question_id")
    private List<Integer> questions;

    @ManyToMany(mappedBy = "competences")
    private List<Position> positions;
}
