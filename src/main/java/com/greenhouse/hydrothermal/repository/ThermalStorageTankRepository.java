package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.ThermalStorageTank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThermalStorageTankRepository
        extends JpaRepository<ThermalStorageTank, Long> {
}