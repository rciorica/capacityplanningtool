package com.company.capacity.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "planning_periods")
public class PlanningPeriod {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
