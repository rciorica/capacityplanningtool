package com.company.capacity.dto.response;

import java.util.List;

public record DashboardSummaryResponse(
        long totalTeams,
        long totalPersons,
        long totalInitiatives,
        long totalEpics,
        long activeInitiatives,
        long overcommittedTeams,
        double avgUtilizationPct,
        List<TeamUtilizationItem> teamUtilizations,
        List<InitiativeRiskItem> atRiskInitiatives
) {
    public record TeamUtilizationItem(String teamId, String teamName, double utilizationPct, String status) {}
    public record InitiativeRiskItem(String initiativeId, String name, String targetDate, String priority) {}
}
