package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.GreenhouseZone;
import com.greenhouse.hydrothermal.service.GreenhouseZoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
public class GreenhouseZoneController {

    private final GreenhouseZoneService service;

    public GreenhouseZoneController(GreenhouseZoneService service) {
        this.service = service;
    }

    @PostMapping
    public GreenhouseZone createZone(@RequestBody GreenhouseZone zone) {
        return service.createZone(zone);
    }

    @GetMapping
    public List<GreenhouseZone> getAllZones() {
        return service.getAllZones();
    }
}