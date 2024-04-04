package com.example.formation_teams.repo;

import com.example.formation_teams.model.AnswerTestValue;
import com.example.formation_teams.model.AnswerTestValueKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerTestValueRepo extends JpaRepository<AnswerTestValue, AnswerTestValueKey> {
}
