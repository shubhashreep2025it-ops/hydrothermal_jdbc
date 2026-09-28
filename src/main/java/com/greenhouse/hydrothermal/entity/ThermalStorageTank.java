package com.greenhouse.hydrothermal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ThermalStorageTank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tankName;
    private double capacityLitres;
    private double currentWaterTemperature;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }

    public double getCapacityLitres() {
        return capacityLitres;
    }

    public void setCapacityLitres(double capacityLitres) {
        this.capacityLitres = capacityLitres;
    }

    public double getCurrentWaterTemperature() {
        return currentWaterTemperature;
    }

    public void setCurrentWaterTemperature(double currentWaterTemperature) {
        this.currentWaterTemperature = currentWaterTemperature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}