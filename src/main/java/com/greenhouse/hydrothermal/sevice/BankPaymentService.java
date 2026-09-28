package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.BankPayment;
import com.greenhouse.hydrothermal.repository.BankPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankPaymentService {

    private final BankPaymentRepository repository;

    public BankPaymentService(BankPaymentRepository repository) {
        this.repository = repository;
    }

    public BankPayment createBankPayment(BankPayment payment) {
        return repository.save(payment);
    }

    public List<BankPayment> getAllBankPayments() {
        return repository.findAll();
    }
}