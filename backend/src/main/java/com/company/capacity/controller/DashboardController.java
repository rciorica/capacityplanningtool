package com.company.capacity.controller;

import com.company.capacity.dto.response.DashboardResponse;
import com.company.capacity.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService service;

    @GetMapping
    public DashboardResponse getDashboard() {
        return service.getDashboard();
    }
}
