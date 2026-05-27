package com.company.capacity.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class InitiativeResponse {
    private UUID id;
    private String name;
    private String description;
    private String priority;
    private String status;
    private LocalDate targetDate;
    private Integer estimatedEffortDays;
    private long epicCount;
    private long completedEpicCount;
}
