package com.company.capacity.service;

import com.company.capacity.dto.request.PlanningPeriodRequest;
import com.company.capacity.dto.response.PlanningPeriodResponse;
import com.company.capacity.exception.ResourceNotFoundException;
import com.company.capacity.mapper.PlanningPeriodMapper;
import com.company.capacity.model.PlanningPeriod;
import com.company.capacity.repository.PlanningPeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlanningPeriodService {

    private final PlanningPeriodRepository repository;
    private final PlanningPeriodMapper mapper;

    public List<PlanningPeriodResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public PlanningPeriodResponse findById(UUID id) {
        PlanningPeriod period = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanningPeriod", id));
        return mapper.toResponse(period);
    }

    public PlanningPeriodResponse create(PlanningPeriodRequest request) {
        PlanningPeriod period = mapper.toEntity(request);
        repository.save(period);
        return mapper.toResponse(period);
    }

    public PlanningPeriodResponse update(UUID id, PlanningPeriodRequest request) {
        PlanningPeriod period = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlanningPeriod", id));

        mapper.updateEntity(request, period);
        repository.save(period);

        return mapper.toResponse(period);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
