package com.company.capacity.service;

import com.company.capacity.dto.request.InitiativeRequest;
import com.company.capacity.dto.response.InitiativeResponse;
import com.company.capacity.exception.ResourceNotFoundException;
import com.company.capacity.mapper.InitiativeMapper;
import com.company.capacity.model.Initiative;
import com.company.capacity.repository.EpicRepository;
import com.company.capacity.repository.InitiativeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InitiativeService {

    private final InitiativeRepository repository;
    private final EpicRepository epicRepository;
    private final InitiativeMapper mapper;

    public List<InitiativeResponse> findAll() {
        return repository.findAll().stream()
                .map(i -> mapper.toResponse(
                        i,
                        epicRepository.findByInitiativeId(i.getId()).size(),
                        epicRepository.findByInitiativeId(i.getId()).stream()
                                .filter(e -> "DONE".equals(e.getStatus()))
                                .count()
                ))
                .toList();
    }

    public InitiativeResponse findById(UUID id) {
        Initiative initiative = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Initiative", id));

        long total = epicRepository.findByInitiativeId(id).size();
        long done = epicRepository.findByInitiativeId(id).stream()
                .filter(e -> "DONE".equals(e.getStatus()))
                .count();

        return mapper.toResponse(initiative, total, done);
    }

    public InitiativeResponse create(InitiativeRequest request) {
        Initiative initiative = mapper.toEntity(request);
        repository.save(initiative);
        return mapper.toResponse(initiative, 0, 0);
    }

    public InitiativeResponse update(UUID id, InitiativeRequest request) {
        Initiative initiative = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Initiative", id));

        mapper.updateEntity(request, initiative);
        repository.save(initiative);

        long total = epicRepository.findByInitiativeId(id).size();
        long done = epicRepository.findByInitiativeId(id).stream()
                .filter(e -> "DONE".equals(e.getStatus()))
                .count();

        return mapper.toResponse(initiative, total, done);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
