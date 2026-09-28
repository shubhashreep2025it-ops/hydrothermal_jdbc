package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository
        extends JpaRepository<SalesOrder, Long> {
}