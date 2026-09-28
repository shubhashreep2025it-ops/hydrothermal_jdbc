package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.CustomerInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInvoiceRepository
        extends JpaRepository<CustomerInvoice, Long> {
}