package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.NetHeatDelivered;
import com.greenhouse.hydrothermal.repository.NetHeatDeliveredRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NetHeatDeliveredService {

    private final NetHeatDeliveredRepository repository;

    private static final double SPECIFIC_HEAT = 4.186;

    public NetHeatDeliveredService(
            NetHeatDeliveredRepository repository) {

        this.repository = repository;
    }

    public NetHeatDelivered calculate(
            NetHeatDelivered heat) {

        double massKg = heat.getWaterVolumeLitres();

        double temperatureDifference =
                heat.getOutletTemperature()
                        - heat.getInletTemperature();

        double heatKj =
                massKg
                        * SPECIFIC_HEAT
                        * temperatureDifference;

        double heatKwh = heatKj / 3600.0;

        heat.setNetHeatKwh(heatKwh);

        heat.setCalculatedAt(LocalDateTime.now());

        return repository.save(heat);
    }

    public List<NetHeatDelivered> getAll() {

        return repository.findAll();
    }
}