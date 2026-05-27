package com.company.capacity.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InitiativeRequest {
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String priority;
    @NotBlank
    private String status;
    private LocalDate targetDate;
    @NotNull
    private Integer estimatedEffortDays;
}
