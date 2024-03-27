package com.example.formation_teams.repo;

import com.example.formation_teams.model.Position;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepo extends JpaRepository<Position, Long> {

    Optional<Position> findById(long id);

    @Query(value = "select positions.position_id, positions.position, is_passed " +
            "from positions join appoint_test on positions.position_id = appoint_test.position_id " +
            "where user_id = ?1",
            nativeQuery = true)
    List<Position> findByUsersUserId(Long userId);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO appoint_test (user_id, position_id) VALUES (?1, ?2)", nativeQuery = true)
    void addPositionUser(Long idUser, Long idPosition);

}
