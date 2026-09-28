package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.Grower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrowerRepository extends JpaRepository<Grower, Long> {
}