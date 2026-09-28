package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository
        extends JpaRepository<JournalEntry, Long> {
}