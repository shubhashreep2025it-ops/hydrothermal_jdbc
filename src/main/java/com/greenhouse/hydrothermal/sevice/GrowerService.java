package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.Grower;
import com.greenhouse.hydrothermal.repository.GrowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrowerService {

    private final GrowerRepository repository;

    public GrowerService(GrowerRepository repository) {
        this.repository = repository;
    }

    public Grower createGrower(Grower grower) {
        return repository.save(grower);
    }

    public List<Grower> getAllGrowers() {
        return repository.findAll();
    }
}