package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.ThermalTelemetry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThermalTelemetryRepository
        extends JpaRepository<ThermalTelemetry, Long> {
}