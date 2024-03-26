package com.example.formation_teams.repo;

import com.example.formation_teams.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepo extends JpaRepository<Position, Long> {

//    @Query(value = "select  count(distinct(user_id)) " +
//            "from teams join user_team_role on teams.id = user_team_role.team_id " +
//            " where company_id = ?1",
    @Query(value = "select positions.position_id as id, positions.position " +
            "from positions join appoint_test on positions.position_id = appoint_test.position_id " +
            "where user_id = ?1",
            nativeQuery = true)
    List<Position> findByUsersUserId(Long userId);
}
