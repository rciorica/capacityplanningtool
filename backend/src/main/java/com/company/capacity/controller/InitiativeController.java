package com.company.capacity.controller;

import com.company.capacity.dto.request.InitiativeRequest;
import com.company.capacity.dto.response.InitiativeResponse;
import com.company.capacity.service.InitiativeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/initiatives")
@RequiredArgsConstructor
public class InitiativeController {

    private final InitiativeService service;

    @GetMapping
    public List<InitiativeResponse> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public InitiativeResponse get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public InitiativeResponse create(@RequestBody InitiativeRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public InitiativeResponse update(@PathVariable UUID id, @RequestBody InitiativeRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
