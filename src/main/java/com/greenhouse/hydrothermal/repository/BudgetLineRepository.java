package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.BudgetLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetLineRepository
        extends JpaRepository<BudgetLine, Long> {
}