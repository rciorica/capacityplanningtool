package com.company.capacity.repository;

import com.company.capacity.model.PlanningPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanningPeriodRepository extends JpaRepository<PlanningPeriod, UUID> {
}
