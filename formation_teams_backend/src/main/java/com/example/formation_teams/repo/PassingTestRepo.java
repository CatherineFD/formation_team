package com.example.formation_teams.repo;

import com.example.formation_teams.dto.request.PassingTestRequest;
import com.example.formation_teams.model.PassingTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassingTestRepo extends JpaRepository<PassingTest, Long> {


}
