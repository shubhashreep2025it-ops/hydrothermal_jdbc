package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}