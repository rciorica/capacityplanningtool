package com.company.capacity.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    @Column(name = "overhead_pct")
    private Double overheadPct;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Person> persons = new ArrayList<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
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
