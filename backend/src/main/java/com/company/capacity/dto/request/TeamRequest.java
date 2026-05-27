package com.company.capacity.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeamRequest {
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private Double overheadPct;
}
