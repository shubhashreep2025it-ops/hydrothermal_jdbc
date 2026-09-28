package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.SeasonalZoneBudget;
import com.greenhouse.hydrothermal.repository.SeasonalZoneBudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonalZoneBudgetService {

    private final SeasonalZoneBudgetRepository repository;

    public SeasonalZoneBudgetService(
            SeasonalZoneBudgetRepository repository) {

        this.repository = repository;
    }

    public SeasonalZoneBudget create(
            SeasonalZoneBudget budget) {

        return repository.save(budget);
    }

    public List<SeasonalZoneBudget> getAll() {

        return repository.findAll();
    }
}