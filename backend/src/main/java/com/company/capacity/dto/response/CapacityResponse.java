package com.company.capacity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class CapacityResponse {

    private UUID teamId;
    private String teamName;

    private UUID periodId;
    private String periodName;

    private double availableDays;
    private double allocatedDays;
    private double utilizationPct;

    private String status;

    private List<PersonCapacityItem> persons;

    @Data
    @AllArgsConstructor
    public static class PersonCapacityItem {
        private UUID personId;
        private String fullName;
        private String role;
        private double availabilityPct;
        private double contributedDays;
    }
}
