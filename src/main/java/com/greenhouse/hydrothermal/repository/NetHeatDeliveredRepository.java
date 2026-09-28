package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.NetHeatDelivered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NetHeatDeliveredRepository
        extends JpaRepository<NetHeatDelivered, Long> {
}