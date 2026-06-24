package org.in28minutes.springboot.violation_tpa.service;

import org.in28minutes.springboot.violation_tpa.entity.AircraftType;
import org.in28minutes.springboot.violation_tpa.repository.AircraftTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftTypeService {

    private final AircraftTypeRepository repository;

    public AircraftTypeService(AircraftTypeRepository repository) {
        this.repository = repository;
    }

    public List<AircraftType> getAll() {
        return repository.findAll();
    }

    public List<AircraftType> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public AircraftType save(AircraftType aircraftType) {
        return repository.save(aircraftType);
    }
}