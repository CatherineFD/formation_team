package com.example.formation_teams.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="appoint_test")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointTest {

    @EmbeddedId
    private AppointTestKey id;

    private boolean isPassed;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="user_id")
    @JsonIgnore
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="position_id")
    @MapsId("positionId")
    private Position position;
}
