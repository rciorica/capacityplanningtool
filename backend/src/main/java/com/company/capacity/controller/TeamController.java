package com.company.capacity.controller;

import com.company.capacity.dto.request.TeamRequest;
import com.company.capacity.dto.response.CapacityResponse;
import com.company.capacity.dto.response.TeamResponse;
import com.company.capacity.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService service;

    @GetMapping
    public List<TeamResponse> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TeamResponse get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public TeamResponse create(@RequestBody TeamRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public TeamResponse update(@PathVariable UUID id, @RequestBody TeamRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @GetMapping("/{teamId}/capacity/{periodId}")
    public CapacityResponse capacity(@PathVariable UUID teamId, @PathVariable UUID periodId) {
        return service.getCapacity(teamId, periodId);
    }
}
