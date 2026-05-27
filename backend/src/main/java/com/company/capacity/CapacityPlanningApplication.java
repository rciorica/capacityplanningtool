package com.company.capacity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CapacityPlanningApplication {
    public static void main(String[] args) {
        SpringApplication.run(CapacityPlanningApplication.class, args);
    }
}
