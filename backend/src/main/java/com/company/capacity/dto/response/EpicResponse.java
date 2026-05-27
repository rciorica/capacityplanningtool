package com.company.capacity.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class EpicResponse {
    private UUID id;
    private String name;
    private String description;
    private Integer estimatedDays;
    private LocalDate dueDate;
    private String status;
    private String confidence;
    private UUID initiativeId;
    private String initiativeName;
    private UUID teamId;
    private String teamName;
}
