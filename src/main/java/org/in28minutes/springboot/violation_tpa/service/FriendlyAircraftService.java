package org.in28minutes.springboot.violation_tpa.service;

import org.in28minutes.springboot.violation_tpa.entity.FriendlyAircraft;
import org.in28minutes.springboot.violation_tpa.repository.FriendlyAircraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendlyAircraftService {

    private final FriendlyAircraftRepository repository;

    public FriendlyAircraftService(FriendlyAircraftRepository repository) {
        this.repository = repository;
    }

    public List<FriendlyAircraft> getAll() {
        return repository.findAll();
    }

    public FriendlyAircraft save(FriendlyAircraft friendlyAircraft) {
        return repository.save(friendlyAircraft);
    }
}