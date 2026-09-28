package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.Grower;
import com.greenhouse.hydrothermal.service.GrowerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/growers")
public class GrowerController {

    private final GrowerService service;

    public GrowerController(GrowerService service) {
        this.service = service;
    }

    @PostMapping
    public Grower createGrower(@RequestBody Grower grower) {
        return service.createGrower(grower);
    }

    @GetMapping
    public List<Grower> getAllGrowers() {
        return service.getAllGrowers();
    }
}