package com.example.formation_teams.dto.request;

import com.example.formation_teams.model.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PositionRequest {

    long id;

//    public Position toPosition() {
//        Position position = new Position();
//
//        position.setPositionId(this.id);
//        return position;
//    }
}
