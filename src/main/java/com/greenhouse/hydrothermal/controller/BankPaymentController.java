package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.BankPayment;
import com.greenhouse.hydrothermal.service.BankPaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-payments")
public class BankPaymentController {

    private final BankPaymentService service;

    public BankPaymentController(BankPaymentService service) {
        this.service = service;
    }

    @PostMapping
    public BankPayment createBankPayment(
            @RequestBody BankPayment payment) {
        return service.createBankPayment(payment);
    }

    @GetMapping
    public List<BankPayment> getAllBankPayments() {
        return service.getAllBankPayments();
    }
}