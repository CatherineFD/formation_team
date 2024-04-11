package com.example.formation_teams.dto.response;

import com.example.formation_teams.model.AppointTest;
import com.example.formation_teams.model.Position;
import com.example.formation_teams.model.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PositionNameResponse {

    private long id;

    private String name;

    private boolean isPassed;

    public static PositionNameResponse fromPositionName(Position position, User user) {
        return builder()
                .id(position.getPositionId())
                .name(position.getPosition())
                .isPassed(getIsAppointTest(position, user))
                .build();
    }

    private static boolean getIsAppointTest(Position position, User user) {
        for(AppointTest appointTest: user.getAppointTests()) {
            if (appointTest.getId().getPositionId() == position.getPositionId()) {
                return appointTest.isPassed();

            }
        }
        return false;
    }
}
