package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.SalesOrder;
import com.greenhouse.hydrothermal.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderService {

    private final SalesOrderRepository repository;

    public SalesOrderService(SalesOrderRepository repository) {
        this.repository = repository;
    }

    public SalesOrder createSalesOrder(SalesOrder salesOrder) {
        return repository.save(salesOrder);
    }

    public List<SalesOrder> getAllSalesOrders() {
        return repository.findAll();
    }
}