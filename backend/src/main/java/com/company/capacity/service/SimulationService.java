package com.company.capacity.service;

import com.company.capacity.dto.request.SimulationRequest;
import com.company.capacity.dto.response.SimulationResponse;
import com.company.capacity.model.Team;
import com.company.capacity.model.PlanningPeriod;
import com.company.capacity.repository.TeamRepository;
import com.company.capacity.repository.PlanningPeriodRepository;
import com.company.capacity.service.capacity.SimulationCapacityStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimulationService {

    private final TeamRepository teamRepository;
    private final PlanningPeriodRepository periodRepository;
    private final SimulationCapacityStrategy simulationStrategy;

    public SimulationResponse simulate(SimulationRequest request) {

        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new RuntimeException("Team not found"));

        PlanningPeriod period = periodRepository.findById(request.getPeriodId())
                .orElseThrow(() -> new RuntimeException("Planning period not found"));

        return simulationStrategy.simulate(team, period, request);
    }
}
