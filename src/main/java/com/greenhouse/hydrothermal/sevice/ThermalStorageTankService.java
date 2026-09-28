package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.ThermalStorageTank;
import com.greenhouse.hydrothermal.repository.ThermalStorageTankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThermalStorageTankService {

    private final ThermalStorageTankRepository repository;

    public ThermalStorageTankService(ThermalStorageTankRepository repository) {
        this.repository = repository;
    }

    public ThermalStorageTank createTank(ThermalStorageTank tank) {
        return repository.save(tank);
    }

    public List<ThermalStorageTank> getAllTanks() {
        return repository.findAll();
    }
}