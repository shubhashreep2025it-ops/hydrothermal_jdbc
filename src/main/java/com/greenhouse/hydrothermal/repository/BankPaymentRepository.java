package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.BankPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankPaymentRepository
        extends JpaRepository<BankPayment, Long> {
}