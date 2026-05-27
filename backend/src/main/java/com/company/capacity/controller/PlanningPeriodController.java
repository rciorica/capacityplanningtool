package com.company.capacity.controller;

import com.company.capacity.dto.request.PlanningPeriodRequest;
import com.company.capacity.dto.response.PlanningPeriodResponse;
import com.company.capacity.service.PlanningPeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/periods")
@RequiredArgsConstructor
public class PlanningPeriodController {

    private final PlanningPeriodService service;

    @GetMapping
    public List<PlanningPeriodResponse> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PlanningPeriodResponse get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public PlanningPeriodResponse create(@RequestBody PlanningPeriodRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public PlanningPeriodResponse update(@PathVariable UUID id, @RequestBody PlanningPeriodRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
