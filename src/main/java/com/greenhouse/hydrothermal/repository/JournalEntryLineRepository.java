package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.JournalEntryLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryLineRepository
        extends JpaRepository<JournalEntryLine, Long> {
}