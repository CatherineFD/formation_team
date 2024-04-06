package com.example.formation_teams.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PassingTestResponse {

    String name;

    List<?> competencies;


}
