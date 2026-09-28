package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.SeasonalZoneBudget;
import com.greenhouse.hydrothermal.service.SeasonalZoneBudgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zone-budgets")
public class SeasonalZoneBudgetController {

    private final SeasonalZoneBudgetService service;

    public SeasonalZoneBudgetController(
            SeasonalZoneBudgetService service) {

        this.service = service;
    }

    @PostMapping
    public SeasonalZoneBudget create(
            @RequestBody SeasonalZoneBudget budget) {

        return service.create(budget);
    }

    @GetMapping
    public List<SeasonalZoneBudget> getAll() {

        return service.getAll();
    }
}