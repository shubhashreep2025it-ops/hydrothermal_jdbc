package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.BudgetLine;
import com.greenhouse.hydrothermal.service.BudgetLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget-lines")
public class BudgetLineController {

    private final BudgetLineService service;

    public BudgetLineController(
            BudgetLineService service) {

        this.service = service;
    }

    @PostMapping
    public BudgetLine create(
            @RequestBody BudgetLine line) {

        return service.create(line);
    }

    @GetMapping
    public List<BudgetLine> getAll() {

        return service.getAll();
    }
}