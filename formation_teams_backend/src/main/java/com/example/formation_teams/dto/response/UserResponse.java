package com.example.formation_teams.dto.response;

import com.example.formation_teams.model.Position;
import com.example.formation_teams.model.User;
import com.example.formation_teams.model.PassingTest;
import com.example.formation_teams.dto.response.PositionNameResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String position;
    private List<PositionNameResponse> positions;
    private List<PassingTestResponse> testResults;

    public static UserResponse fromUser(User user) {

        Map<Position, PassingTest> latestTestsByPosition = user.getPassingTest().stream()
                .collect(Collectors.groupingBy(PassingTest::getPosition,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(PassingTest::getDatePassing)),
                                Optional::get)));

        List<PassingTest> latestTests = latestTestsByPosition.values().stream()
                .collect(Collectors.toList());
        return builder()
                .id(user.getId())
                .email(user.getEmail())
                .phone(user.getPhone())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .position(user.getPosition())
                .positions(user.getPositions().stream().map(PositionNameResponse::fromPositionName).toList())
                .testResults(latestTests.stream().map(PassingTestResponse::fromPassingTest).toList())
                .build();
    }
}
