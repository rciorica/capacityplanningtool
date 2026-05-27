package com.company.capacity.dto.response;

public record SimulationResponse(
        double currentAvailableDays,
        double currentAllocatedDays,
        double currentUtilizationPct,
        double simulatedAvailableDays,
        double simulatedAllocatedDays,
        double simulatedUtilizationPct,
        double deltaUtilizationPct,
        String simulatedStatus,
        String recommendation
) {}
