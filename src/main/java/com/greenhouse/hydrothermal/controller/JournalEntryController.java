package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.JournalEntry;
import com.greenhouse.hydrothermal.service.JournalEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal-entries")
public class JournalEntryController {

    private final JournalEntryService service;

    public JournalEntryController(JournalEntryService service) {
        this.service = service;
    }

    @PostMapping
    public JournalEntry createJournalEntry(
            @RequestBody JournalEntry entry) {
        return service.createJournalEntry(entry);
    }

    @GetMapping
    public List<JournalEntry> getAllJournalEntries() {
        return service.getAllJournalEntries();
    }
}