package com.company.capacity.service.capacity;

import com.company.capacity.dto.request.SimulationRequest;
import com.company.capacity.dto.response.CapacityResponse;
import com.company.capacity.dto.response.SimulationResponse;
import com.company.capacity.model.Person;
import com.company.capacity.model.PlanningPeriod;
import com.company.capacity.model.Team;
import com.company.capacity.repository.EpicRepository;
import com.company.capacity.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static com.company.capacity.service.capacity.StandardCapacityStrategy.countWorkingDays;
import static com.company.capacity.service.capacity.StandardCapacityStrategy.resolveStatus;

@Component
public class SimulationCapacityStrategy implements CapacityStrategy {

    private final PersonRepository personRepository;
    private final EpicRepository epicRepository;
    private final StandardCapacityStrategy standard;

    public SimulationCapacityStrategy(PersonRepository personRepository,
                                      EpicRepository epicRepository,
                                      StandardCapacityStrategy standard) {
        this.personRepository = personRepository;
        this.epicRepository = epicRepository;
        this.standard = standard;
    }

    @Override
    public CapacityResponse calculate(Team team, PlanningPeriod period) {
        return standard.calculate(team, period);
    }

    public SimulationResponse simulate(Team team, PlanningPeriod period, SimulationRequest request) {
        CapacityResponse current = standard.calculate(team, period);

        BigDecimal overheadOverride = request.getOverrideOverheadPct() != null
                ? request.getOverrideOverheadPct()
                : BigDecimal.valueOf(team.getOverheadPct());

        List<Person> persons = personRepository.findByTeamId(team.getId());
        long workingDays = countWorkingDays(period.getStartDate(), period.getEndDate());
        double simOverheadFactor = 1.0 - (overheadOverride.doubleValue() / 100.0);

        double totalAvailability = persons.stream()
                .mapToDouble(p -> p.getAvailabilityPct().doubleValue() / 100.0)
                .sum();
        double simAvailable = workingDays * totalAvailability * simOverheadFactor;

        int extraDays = request.getAdditionalEpicDays() != null
                ? request.getAdditionalEpicDays().stream().mapToInt(Integer::intValue).sum()
                : 0;

        double simAllocated = current.getAllocatedDays() + extraDays;

        double simUtil = simAvailable > 0 ? (simAllocated / simAvailable) * 100.0 : 0.0;
        double delta = simUtil - current.getUtilizationPct();
        String simStatus = resolveStatus(simUtil);

        String recommendation = buildRecommendation(simUtil, delta);

        return new SimulationResponse(
                current.getAvailableDays(), current.getAllocatedDays(), current.getUtilizationPct(),
                round(simAvailable), round(simAllocated), round(simUtil),
                round(delta), simStatus, recommendation);
    }

    private String buildRecommendation(double simUtil, double delta) {
        if (simUtil > 100) return "Team will be overcommitted. Consider reducing scope or adding capacity.";
        if (simUtil > 80) return "Team is at risk. Monitor closely and avoid adding more work.";
        if (delta < 0) return "Reducing overhead improves capacity. Safe to proceed.";
        return "Plan looks feasible within available capacity.";
    }

    private static double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
