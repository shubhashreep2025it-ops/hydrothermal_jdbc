package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository
        extends JpaRepository<PurchaseOrder, Long> {
}