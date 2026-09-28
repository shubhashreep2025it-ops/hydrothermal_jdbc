package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.CustomerPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPaymentRepository
        extends JpaRepository<CustomerPayment, Long> {
}