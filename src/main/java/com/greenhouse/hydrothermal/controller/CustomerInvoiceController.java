package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.CustomerInvoice;
import com.greenhouse.hydrothermal.service.CustomerInvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-invoices")
public class CustomerInvoiceController {

    private final CustomerInvoiceService service;

    public CustomerInvoiceController(CustomerInvoiceService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerInvoice createCustomerInvoice(
            @RequestBody CustomerInvoice invoice) {
        return service.createCustomerInvoice(invoice);
    }

    @GetMapping
    public List<CustomerInvoice> getAllCustomerInvoices() {
        return service.getAllCustomerInvoices();
    }
}