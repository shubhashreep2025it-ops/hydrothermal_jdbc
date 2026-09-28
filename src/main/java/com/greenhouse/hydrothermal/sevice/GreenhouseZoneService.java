package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.GreenhouseZone;
import com.greenhouse.hydrothermal.repository.GreenhouseZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenhouseZoneService {

    private final GreenhouseZoneRepository repository;

    public GreenhouseZoneService(GreenhouseZoneRepository repository) {
        this.repository = repository;
    }

    public GreenhouseZone createZone(GreenhouseZone zone) {
        return repository.save(zone);
    }

    public List<GreenhouseZone> getAllZones() {
        return repository.findAll();
    }
}