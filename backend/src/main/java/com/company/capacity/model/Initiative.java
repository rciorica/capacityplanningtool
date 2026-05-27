package com.company.capacity.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "initiatives")
public class Initiative {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    private String priority;

    private String status;

    @Column(name = "target_date")
    private LocalDate targetDate;

    @Column(name = "estimated_effort_days")
    private Integer estimatedEffortDays;

    @OneToMany(mappedBy = "initiative", fetch = FetchType.LAZY)
    private List<Epic> epics = new ArrayList<>();

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
