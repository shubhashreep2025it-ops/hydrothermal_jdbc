package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.JournalEntryLine;
import com.greenhouse.hydrothermal.repository.JournalEntryLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryLineService {

    private final JournalEntryLineRepository repository;

    public JournalEntryLineService(
            JournalEntryLineRepository repository) {

        this.repository = repository;
    }

    public JournalEntryLine create(
            JournalEntryLine line) {

        return repository.save(line);
    }

    public List<JournalEntryLine> getAll() {

        return repository.findAll();
    }
}