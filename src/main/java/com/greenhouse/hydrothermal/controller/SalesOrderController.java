package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.SalesOrder;
import com.greenhouse.hydrothermal.service.SalesOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-orders")
public class SalesOrderController {

    private final SalesOrderService service;

    public SalesOrderController(SalesOrderService service) {
        this.service = service;
    }

    @PostMapping
    public SalesOrder createSalesOrder(
            @RequestBody SalesOrder salesOrder) {
        return service.createSalesOrder(salesOrder);
    }

    @GetMapping
    public List<SalesOrder> getAllSalesOrders() {
        return service.getAllSalesOrders();
    }
}