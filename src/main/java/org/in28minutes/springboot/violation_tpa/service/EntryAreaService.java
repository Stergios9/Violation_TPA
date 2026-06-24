package org.in28minutes.springboot.violation_tpa.service;

import org.in28minutes.springboot.violation_tpa.entity.EntryArea;
import org.in28minutes.springboot.violation_tpa.repository.EntryAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryAreaService {

    private final EntryAreaRepository repository;

    public EntryAreaService(EntryAreaRepository repository) {
        this.repository = repository;
    }

    public List<EntryArea> getAll() {
        return repository.findAll();
    }

    public EntryArea save(EntryArea entryArea) {
        return repository.save(entryArea);
    }
}