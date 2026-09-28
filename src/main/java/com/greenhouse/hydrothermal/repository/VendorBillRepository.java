package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.VendorBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorBillRepository
        extends JpaRepository<VendorBill, Long> {
}