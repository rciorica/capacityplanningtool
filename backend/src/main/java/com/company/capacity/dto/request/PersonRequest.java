package com.company.capacity.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class PersonRequest {
    @NotBlank
    private String fullName;
    @NotNull
    private UUID teamId;
    @NotBlank
    private String role;
    @NotNull
    private Double availabilityPct;
}
