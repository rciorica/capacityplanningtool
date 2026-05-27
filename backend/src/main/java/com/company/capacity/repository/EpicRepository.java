package com.company.capacity.repository;

import com.company.capacity.model.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface EpicRepository extends JpaRepository<Epic, UUID> {

    long countByStatus(String status);

    List<Epic> findByTeamId(UUID teamId);

    List<Epic> findByInitiativeId(UUID initiativeId);

    @Query("""
        SELECT SUM(e.estimatedDays)
        FROM Epic e
        WHERE e.team.id = :teamId
          AND e.dueDate BETWEEN :start AND :end
    """)
    Double sumAllocatedDaysByTeamAndPeriod(UUID teamId, LocalDate start, LocalDate end);
}
