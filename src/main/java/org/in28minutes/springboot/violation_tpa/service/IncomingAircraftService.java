package org.in28minutes.springboot.violation_tpa.service;

import org.in28minutes.springboot.violation_tpa.entity.IncomingAircraft;
import org.in28minutes.springboot.violation_tpa.repository.IncomingAircraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomingAircraftService {

    private final IncomingAircraftRepository repository;

    public IncomingAircraftService(IncomingAircraftRepository repository) {
        this.repository = repository;
    }

    public List<IncomingAircraft> getAll() {
        return repository.findAll();
    }

    public List<IncomingAircraft> getByIncidentId(Long incidentId) {
        return repository.findByIncidentId(incidentId);
    }

    public IncomingAircraft save(IncomingAircraft incomingAircraft) {
        return repository.save(incomingAircraft);
    }
}
