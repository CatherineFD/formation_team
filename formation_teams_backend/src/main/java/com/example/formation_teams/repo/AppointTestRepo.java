package com.example.formation_teams.repo;

import com.example.formation_teams.model.AppointTest;
import com.example.formation_teams.model.AppointTestKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointTestRepo extends JpaRepository<AppointTest, AppointTestKey> {

}
