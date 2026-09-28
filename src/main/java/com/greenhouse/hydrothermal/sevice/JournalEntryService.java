package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.JournalEntry;
import com.greenhouse.hydrothermal.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryService {

    private final JournalEntryRepository repository;

    public JournalEntryService(JournalEntryRepository repository) {
        this.repository = repository;
    }

    public JournalEntry createJournalEntry(JournalEntry entry) {
        return repository.save(entry);
    }

    public List<JournalEntry> getAllJournalEntries() {
        return repository.findAll();
    }
}