package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.BudgetLine;
import com.greenhouse.hydrothermal.repository.BudgetLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetLineService {

    private final BudgetLineRepository repository;

    public BudgetLineService(
            BudgetLineRepository repository) {

        this.repository = repository;
    }

    public BudgetLine create(
            BudgetLine line) {

        return repository.save(line);
    }

    public List<BudgetLine> getAll() {

        return repository.findAll();
    }
}