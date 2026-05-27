package com.company.capacity.repository;

import com.company.capacity.model.Initiative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InitiativeRepository extends JpaRepository<Initiative, UUID> {

    long countByStatus(String status);
}
