package com.company.capacity.controller;

import com.company.capacity.dto.request.PersonRequest;
import com.company.capacity.dto.response.PersonResponse;
import com.company.capacity.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping
    public List<PersonResponse> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonResponse get(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public PersonResponse create(@RequestBody PersonRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public PersonResponse update(@PathVariable UUID id, @RequestBody PersonRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
