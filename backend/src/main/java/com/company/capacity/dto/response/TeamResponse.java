package com.company.capacity.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class TeamResponse {
    private UUID id;
    private String name;
    private String description;
    private Double overheadPct;
    private int memberCount;
}
