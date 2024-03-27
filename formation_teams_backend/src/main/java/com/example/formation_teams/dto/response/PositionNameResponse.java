package com.example.formation_teams.dto.response;

import com.example.formation_teams.model.Position;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PositionNameResponse {

    private long id;

    private String name;

    public static PositionNameResponse fromPositionName(Position position) {
        return builder()
                .id(position.getPositionId())
                .name(position.getPosition())
                .build();
    }
}
