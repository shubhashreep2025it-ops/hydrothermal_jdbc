package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.ChartOfAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartOfAccountRepository extends JpaRepository<ChartOfAccount, Long> {
}