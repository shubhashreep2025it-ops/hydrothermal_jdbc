package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.SeasonalZoneBudget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonalZoneBudgetRepository
        extends JpaRepository<SeasonalZoneBudget, Long> {
}