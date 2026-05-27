package com.company.capacity.service;

import com.company.capacity.dto.request.TeamRequest;
import com.company.capacity.dto.response.CapacityResponse;
import com.company.capacity.dto.response.TeamResponse;
import com.company.capacity.exception.ResourceNotFoundException;
import com.company.capacity.mapper.TeamMapper;
import com.company.capacity.model.Team;
import com.company.capacity.repository.PersonRepository;
import com.company.capacity.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository repository;
    private final PersonRepository personRepository;
    private final TeamMapper mapper;
    private final CapacityService capacityService;

    public List<TeamResponse> findAll() {
        return repository.findAll().stream()
                .map(team -> mapper.toResponse(team, personRepository.findByTeamId(team.getId()).size()))
                .toList();
    }

    public TeamResponse findById(UUID id) {
        Team team = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team", id));

        int memberCount = personRepository.findByTeamId(id).size();
        return mapper.toResponse(team, memberCount);
    }

    public TeamResponse create(TeamRequest request) {
        Team team = mapper.toEntity(request);
        repository.save(team);
        return mapper.toResponse(team, 0);
    }

    public TeamResponse update(UUID id, TeamRequest request) {
        Team team = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team", id));

        mapper.updateEntity(request, team);
        repository.save(team);

        int memberCount = personRepository.findByTeamId(id).size();
        return mapper.toResponse(team, memberCount);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public CapacityResponse getCapacity(UUID teamId, UUID periodId) {
        return capacityService.calculate(teamId, periodId);
    }
}
