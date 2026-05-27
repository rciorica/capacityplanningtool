package com.company.capacity.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    private String role;

    @Column(name = "availability_pct")
    private Double availabilityPct;

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
