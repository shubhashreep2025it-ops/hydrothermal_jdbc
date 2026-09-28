package com.greenhouse.hydrothermal.entity;

import jakarta.persistence.*;

@Entity
public class SeasonalZoneBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long zoneId;
    private String season;
    private double plannedHeatKwh;
    private double plannedRevenue;
    private double plannedExpense;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public double getPlannedHeatKwh() {
        return plannedHeatKwh;
    }

    public void setPlannedHeatKwh(double plannedHeatKwh) {
        this.plannedHeatKwh = plannedHeatKwh;
    }

    public double getPlannedRevenue() {
        return plannedRevenue;
    }

    public void setPlannedRevenue(double plannedRevenue) {
        this.plannedRevenue = plannedRevenue;
    }

    public double getPlannedExpense() {
        return plannedExpense;
    }

    public void setPlannedExpense(double plannedExpense) {
        this.plannedExpense = plannedExpense;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}