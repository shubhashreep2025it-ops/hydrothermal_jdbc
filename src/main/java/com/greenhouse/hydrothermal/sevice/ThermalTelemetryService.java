package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.ThermalTelemetry;
import com.greenhouse.hydrothermal.repository.ThermalTelemetryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThermalTelemetryService {

    private final ThermalTelemetryRepository repository;

    public ThermalTelemetryService(ThermalTelemetryRepository repository) {
        this.repository = repository;
    }

    public ThermalTelemetry createTelemetry(ThermalTelemetry telemetry) {
        return repository.save(telemetry);
    }

    public List<ThermalTelemetry> getAllTelemetry() {
        return repository.findAll();
    }
}