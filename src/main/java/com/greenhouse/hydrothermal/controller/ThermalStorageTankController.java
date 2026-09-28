package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.ThermalStorageTank;
import com.greenhouse.hydrothermal.service.ThermalStorageTankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tanks")
public class ThermalStorageTankController {

    private final ThermalStorageTankService service;

    public ThermalStorageTankController(ThermalStorageTankService service) {
        this.service = service;
    }

    @PostMapping
    public ThermalStorageTank createTank(@RequestBody ThermalStorageTank tank) {
        return service.createTank(tank);
    }

    @GetMapping
    public List<ThermalStorageTank> getAllTanks() {
        return service.getAllTanks();
    }
}