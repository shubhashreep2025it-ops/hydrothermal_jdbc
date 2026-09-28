package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.CustomerPayment;
import com.greenhouse.hydrothermal.repository.CustomerPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerPaymentService {

    private final CustomerPaymentRepository repository;

    public CustomerPaymentService(CustomerPaymentRepository repository) {
        this.repository = repository;
    }

    public CustomerPayment createCustomerPayment(
            CustomerPayment payment) {
        return repository.save(payment);
    }

    public List<CustomerPayment> getAllCustomerPayments() {
        return repository.findAll();
    }
}