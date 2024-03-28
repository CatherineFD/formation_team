package com.example.formation_teams.repo;


import com.example.formation_teams.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetenceRepo extends JpaRepository<Competence, Long> {

    Optional<Competence> findById(Long id);

    @Query(value = "select test_value.competence_id " +
            "from test_value where position_id = ?1",
            nativeQuery = true)
    List<Long> findByPositionId(Long id);


}
