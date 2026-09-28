package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.CustomerInvoice;
import com.greenhouse.hydrothermal.repository.CustomerInvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInvoiceService {

    private final CustomerInvoiceRepository repository;

    public CustomerInvoiceService(CustomerInvoiceRepository repository) {
        this.repository = repository;
    }

    public CustomerInvoice createCustomerInvoice(
            CustomerInvoice invoice) {
        return repository.save(invoice);
    }

    public List<CustomerInvoice> getAllCustomerInvoices() {
        return repository.findAll();
    }
}