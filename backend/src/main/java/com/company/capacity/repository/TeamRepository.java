package com.company.capacity.repository;

import com.company.capacity.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
}
