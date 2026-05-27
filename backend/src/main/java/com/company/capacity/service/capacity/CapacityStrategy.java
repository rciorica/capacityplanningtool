package com.company.capacity.service.capacity;

import com.company.capacity.dto.response.CapacityResponse;
import com.company.capacity.model.PlanningPeriod;
import com.company.capacity.model.Team;

public interface CapacityStrategy {
    CapacityResponse calculate(Team team, PlanningPeriod period);
}
