package com.company.capacity.service;

import com.company.capacity.dto.response.DashboardResponse;
import com.company.capacity.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final TeamRepository teamRepository;
    private final PersonRepository personRepository;
    private final InitiativeRepository initiativeRepository;
    private final EpicRepository epicRepository;

    public DashboardResponse getDashboard() {

        long teamCount = teamRepository.count();
        long personCount = personRepository.count();
        long initiativeCount = initiativeRepository.count();
        long epicCount = epicRepository.count();

        long completedEpics = epicRepository.countByStatus("DONE");

        return DashboardResponse.builder()
                .teamCount(teamCount)
                .personCount(personCount)
                .initiativeCount(initiativeCount)
                .epicCount(epicCount)
                .completedEpicCount(completedEpics)
                .build();
    }
}
