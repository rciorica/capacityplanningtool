package com.company.capacity.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class SimulationRequest {

    private UUID teamId;
    private UUID periodId;

    // Suprascriere overhead (în procente)
    private BigDecimal overrideOverheadPct;

    // Suprascriere disponibilitate (în procente)
    private BigDecimal overrideAvailabilityPct;

    // Listă de zile suplimentare pentru epics
    private List<Integer> additionalEpicDays;
}
