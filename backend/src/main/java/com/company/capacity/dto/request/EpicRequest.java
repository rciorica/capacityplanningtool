package com.company.capacity.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EpicRequest {
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private UUID initiativeId;
    @NotNull
    private UUID teamId;
    @NotNull
    private Integer estimatedDays;
    private LocalDate dueDate;
    @NotBlank
    private String status;
    @NotBlank
    private String confidence;
}
