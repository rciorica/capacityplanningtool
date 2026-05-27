package com.company.capacity.service;

import com.company.capacity.dto.request.PersonRequest;
import com.company.capacity.dto.response.PersonResponse;
import com.company.capacity.exception.ResourceNotFoundException;
import com.company.capacity.mapper.PersonMapper;
import com.company.capacity.model.Person;
import com.company.capacity.model.Team;
import com.company.capacity.repository.PersonRepository;
import com.company.capacity.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;
    private final TeamRepository teamRepository;
    private final PersonMapper mapper;

    public List<PersonResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public PersonResponse findById(UUID id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person", id));
        return mapper.toResponse(person);
    }

    public PersonResponse create(PersonRequest request) {
        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new ResourceNotFoundException("Team", request.getTeamId()));

        Person person = mapper.toEntity(request, team);
        repository.save(person);

        return mapper.toResponse(person);
    }

    public PersonResponse update(UUID id, PersonRequest request) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person", id));

        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new ResourceNotFoundException("Team", request.getTeamId()));

        mapper.updateEntity(request, person, team);
        repository.save(person);

        return mapper.toResponse(person);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
