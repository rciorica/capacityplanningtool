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
@Table(name = "epics")
public class Epic {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    @Column(name = "estimated_days")
    private Integer estimatedDays;

    @Column(name = "due_date")
    private LocalDate dueDate;

    private String status;

    private String confidence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initiative_id")
    private Initiative initiative;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
