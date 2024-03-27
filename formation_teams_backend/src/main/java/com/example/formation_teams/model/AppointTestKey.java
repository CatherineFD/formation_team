package com.example.formation_teams.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AppointTestKey implements Serializable {

    @Column(name="user_id",insertable=false, updatable=false)
    private long userId;

    @Column(name="position_id",insertable=false, updatable=false)
    private long positionId;

}
