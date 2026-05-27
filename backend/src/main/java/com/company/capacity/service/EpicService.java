package com.company.capacity.service;

import com.company.capacity.dto.request.EpicRequest;
import com.company.capacity.dto.response.EpicResponse;
import com.company.capacity.exception.ResourceNotFoundException;
import com.company.capacity.mapper.EpicMapper;
import com.company.capacity.model.Epic;
import com.company.capacity.model.Initiative;
import com.company.capacity.model.Team;
import com.company.capacity.repository.EpicRepository;
import com.company.capacity.repository.InitiativeRepository;
import com.company.capacity.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EpicService {

    private final EpicRepository repository;
    private final TeamRepository teamRepository;
    private final InitiativeRepository initiativeRepository;
    private final EpicMapper mapper;

    public List<EpicResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public EpicResponse findById(UUID id) {
        Epic epic = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Epic", id));
        return mapper.toResponse(epic);
    }

    public EpicResponse create(EpicRequest request) {
        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new ResourceNotFoundException("Team", request.getTeamId()));

        Initiative initiative = initiativeRepository.findById(request.getInitiativeId())
                .orElseThrow(() -> new ResourceNotFoundException("Initiative", request.getInitiativeId()));

        Epic epic = mapper.toEntity(request, team, initiative);
        repository.save(epic);

        return mapper.toResponse(epic);
    }

    public EpicResponse update(UUID id, EpicRequest request) {
        Epic epic = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Epic", id));

        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new ResourceNotFoundException("Team", request.getTeamId()));

        Initiative initiative = initiativeRepository.findById(request.getInitiativeId())
                .orElseThrow(() -> new ResourceNotFoundException("Initiative", request.getInitiativeId()));

        mapper.updateEntity(request, epic, team, initiative);
        repository.save(epic);

        return mapper.toResponse(epic);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
