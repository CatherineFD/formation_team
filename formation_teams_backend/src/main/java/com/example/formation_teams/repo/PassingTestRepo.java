package com.example.formation_teams.repo;

import com.example.formation_teams.dto.request.PassingTestRequest;
import com.example.formation_teams.model.PassingTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassingTestRepo extends JpaRepository<PassingTest, Long> {

}
