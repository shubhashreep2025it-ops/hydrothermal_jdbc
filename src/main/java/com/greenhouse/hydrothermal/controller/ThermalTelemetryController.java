package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.ThermalTelemetry;
import com.greenhouse.hydrothermal.service.ThermalTelemetryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telemetry")
public class ThermalTelemetryController {

    private final ThermalTelemetryService service;

    public ThermalTelemetryController(ThermalTelemetryService service) {
        this.service = service;
    }

    @PostMapping
    public ThermalTelemetry createTelemetry(
            @RequestBody ThermalTelemetry telemetry) {
        return service.createTelemetry(telemetry);
    }

    @GetMapping
    public List<ThermalTelemetry> getAllTelemetry() {
        return service.getAllTelemetry();
    }
}