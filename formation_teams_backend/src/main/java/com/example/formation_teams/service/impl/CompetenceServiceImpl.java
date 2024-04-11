package com.example.formation_teams.service.impl;

import com.example.formation_teams.dto.response.CompetenceResponse;
import com.example.formation_teams.model.Competence;
import com.example.formation_teams.repo.CompetenceRepo;
import com.example.formation_teams.service.CompetenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {

    public static List<CompetenceResponse> mixingCompetence(List<CompetenceResponse> competencies) {
        Random rnd = ThreadLocalRandom.current();

        for (CompetenceResponse competence : competencies) {
            competence.setQuestions(CompetenceServiceImpl.mixingQuestions(competence.getQuestions()));
        }

        for (int i = competencies.size() - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);

            CompetenceResponse competence1 = competencies.get(i);
            CompetenceResponse competence2 = competencies.get(j);

            competencies.set(i, competence2);
            competencies.set(j, competence1);
        }

        return competencies;
    }

    private static List<Integer> mixingQuestions(List<Integer> questions) {
        Random rnd = ThreadLocalRandom.current();

        for (int i = questions.size() - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);

            Integer question1 = questions.get(i);
            Integer question2 = questions.get(j);

            questions.set(i, question2);
            questions.set(j, question1);
        }

        return questions;
    }
}
