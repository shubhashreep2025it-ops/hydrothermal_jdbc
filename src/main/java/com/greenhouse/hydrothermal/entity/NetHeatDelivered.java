package com.greenhouse.hydrothermal.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class NetHeatDelivered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tankId;
    private double waterVolumeLitres;
    private double inletTemperature;
    private double outletTemperature;
    private double netHeatKwh;
    private LocalDateTime calculatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTankId() {
        return tankId;
    }

    public void setTankId(Long tankId) {
        this.tankId = tankId;
    }

    public double getWaterVolumeLitres() {
        return waterVolumeLitres;
    }

    public void setWaterVolumeLitres(double waterVolumeLitres) {
        this.waterVolumeLitres = waterVolumeLitres;
    }

    public double getInletTemperature() {
        return inletTemperature;
    }

    public void setInletTemperature(double inletTemperature) {
        this.inletTemperature = inletTemperature;
    }

    public double getOutletTemperature() {
        return outletTemperature;
    }

    public void setOutletTemperature(double outletTemperature) {
        this.outletTemperature = outletTemperature;
    }

    public double getNetHeatKwh() {
        return netHeatKwh;
    }

    public void setNetHeatKwh(double netHeatKwh) {
        this.netHeatKwh = netHeatKwh;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
}