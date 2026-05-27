package com.company.capacity.service.capacity;

import com.company.capacity.dto.response.CapacityResponse;
import com.company.capacity.model.Person;
import com.company.capacity.model.PlanningPeriod;
import com.company.capacity.model.Team;
import com.company.capacity.repository.EpicRepository;
import com.company.capacity.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;

@Primary
@Component("standardCapacityStrategy")
public class StandardCapacityStrategy implements CapacityStrategy {

    private final PersonRepository personRepository;
    private final EpicRepository epicRepository;

    public StandardCapacityStrategy(PersonRepository personRepository, EpicRepository epicRepository) {
        this.personRepository = personRepository;
        this.epicRepository = epicRepository;
    }

    @Override
    public CapacityResponse calculate(Team team, PlanningPeriod period) {
        List<Person> persons = personRepository.findByTeamId(team.getId());

        long workingDays = countWorkingDays(period.getStartDate(), period.getEndDate());
        double overheadFactor = 1.0 - (team.getOverheadPct().doubleValue() / 100.0);

        List<CapacityResponse.PersonCapacityItem> personItems = persons.stream()
                .map(p -> {
                    double contributed = workingDays * (p.getAvailabilityPct().doubleValue() / 100.0) * overheadFactor;
                    return new CapacityResponse.PersonCapacityItem(
       			 p.getId(),
       			 p.getFullName(),
       			 p.getRole(), // <-- String, nu enum
       			 p.getAvailabilityPct().doubleValue(),
       			 round(contributed)
			);

                })
                .collect(Collectors.toList());

        double totalAvailability = persons.stream()
                .mapToDouble(p -> p.getAvailabilityPct().doubleValue() / 100.0)
                .sum();

        double availableDays = workingDays * totalAvailability * overheadFactor;

        Double rawAllocated = epicRepository.sumAllocatedDaysByTeamAndPeriod(
                team.getId(), period.getStartDate(), period.getEndDate());
        double allocatedDays = rawAllocated != null ? rawAllocated : 0.0;

        double utilizationPct = availableDays > 0 ? (allocatedDays / availableDays) * 100.0 : 0.0;
        String status = resolveStatus(utilizationPct);

        return new CapacityResponse(
                team.getId(), team.getName(),
                period.getId(), period.getName(),
                round(availableDays), round(allocatedDays),
                round(utilizationPct), status, personItems);
    }

    public static long countWorkingDays(LocalDate start, LocalDate end) {
        return start.datesUntil(end.plusDays(1))
                .filter(d -> d.getDayOfWeek() != DayOfWeek.SATURDAY && d.getDayOfWeek() != DayOfWeek.SUNDAY)
                .count();
    }

    public static String resolveStatus(double utilPct) {
        if (utilPct > 100.0) return "OVERCOMMITTED";
        if (utilPct > 80.0) return "AT_RISK";
        return "OK";
    }

    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
