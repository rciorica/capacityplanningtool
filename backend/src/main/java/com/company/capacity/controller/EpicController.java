package com.company.capacity.controller;

import com.company.capacity.dto.request.EpicRequest;
import com.company.capacity.dto.response.EpicResponse;
import com.company.capacity.service.EpicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/epics")
@RequiredArgsConstructor
public class EpicController {

    private final EpicService service;

    @GetMapping
    public List<EpicResponse> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EpicResponse get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public EpicResponse create(@RequestBody EpicRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public EpicResponse update(@PathVariable UUID id, @RequestBody EpicRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
