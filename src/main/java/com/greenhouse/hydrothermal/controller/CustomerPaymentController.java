package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.CustomerPayment;
import com.greenhouse.hydrothermal.service.CustomerPaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-payments")
public class CustomerPaymentController {

    private final CustomerPaymentService service;

    public CustomerPaymentController(CustomerPaymentService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerPayment createCustomerPayment(
            @RequestBody CustomerPayment payment) {
        return service.createCustomerPayment(payment);
    }

    @GetMapping
    public List<CustomerPayment> getAllCustomerPayments() {
        return service.getAllCustomerPayments();
    }
}