package com.company.capacity.controller;

import com.company.capacity.dto.request.SimulationRequest;
import com.company.capacity.dto.response.SimulationResponse;
import com.company.capacity.service.SimulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulation")
@RequiredArgsConstructor
public class SimulationController {

    private final SimulationService simulationService;

    @PostMapping
    public SimulationResponse simulate(@RequestBody SimulationRequest request) {
        return simulationService.simulate(request);
    }
}
