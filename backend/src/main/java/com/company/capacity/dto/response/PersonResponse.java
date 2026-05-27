package com.company.capacity.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PersonResponse {
    private UUID id;
    private String fullName;
    private String role;
    private Double availabilityPct;
    private UUID teamId;
    private String teamName;
}
