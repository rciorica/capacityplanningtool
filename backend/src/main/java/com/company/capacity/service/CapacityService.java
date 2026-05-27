package com.company.capacity.service;

import com.company.capacity.dto.response.CapacityResponse;
import com.company.capacity.exception.ResourceNotFoundException;
import com.company.capacity.model.PlanningPeriod;
import com.company.capacity.model.Team;
import com.company.capacity.repository.PlanningPeriodRepository;
import com.company.capacity.repository.TeamRepository;
import com.company.capacity.service.capacity.CapacityStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CapacityService {

    private final TeamRepository teamRepository;
    private final PlanningPeriodRepository periodRepository;
    private final CapacityStrategy capacityStrategy;

    public CapacityResponse calculate(UUID teamId, UUID periodId) {

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team", teamId));

        PlanningPeriod period = periodRepository.findById(periodId)
                .orElseThrow(() -> new ResourceNotFoundException("PlanningPeriod", periodId));

        return capacityStrategy.calculate(team, period);
    }
}
