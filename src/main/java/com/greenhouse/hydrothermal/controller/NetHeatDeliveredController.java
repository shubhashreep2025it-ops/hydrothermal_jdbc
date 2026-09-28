package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.NetHeatDelivered;
import com.greenhouse.hydrothermal.service.NetHeatDeliveredService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/net-heat")
public class NetHeatDeliveredController {

    private final NetHeatDeliveredService service;

    public NetHeatDeliveredController(
            NetHeatDeliveredService service) {

        this.service = service;
    }

    @PostMapping
    public NetHeatDelivered calculate(
            @RequestBody NetHeatDelivered heat) {

        return service.calculate(heat);
    }

    @GetMapping
    public List<NetHeatDelivered> getAll() {

        return service.getAll();
    }
}