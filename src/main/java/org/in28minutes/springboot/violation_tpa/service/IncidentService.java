package org.in28minutes.springboot.violation_tpa.service;

import org.in28minutes.springboot.violation_tpa.dto.IncidentForm;
import org.in28minutes.springboot.violation_tpa.dto.IncomingAircraftDTO;
import org.in28minutes.springboot.violation_tpa.entity.*;
import org.in28minutes.springboot.violation_tpa.repository.AircraftTypeRepository;
import org.in28minutes.springboot.violation_tpa.repository.EntryAreaRepository;
import org.in28minutes.springboot.violation_tpa.repository.FriendlyAircraftRepository;
import org.in28minutes.springboot.violation_tpa.repository.IncidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final EntryAreaRepository entryAreaRepository;
    private final FriendlyAircraftRepository friendlyAircraftRepository;
    private final AircraftTypeRepository aircraftTypeRepository;

    public IncidentService(IncidentRepository incidentRepository,
                           EntryAreaRepository entryAreaRepository,
                           FriendlyAircraftRepository friendlyAircraftRepository,
                           AircraftTypeRepository aircraftTypeRepository) {
        this.incidentRepository = incidentRepository;
        this.entryAreaRepository = entryAreaRepository;
        this.friendlyAircraftRepository = friendlyAircraftRepository;
        this.aircraftTypeRepository = aircraftTypeRepository;
    }

    @Transactional
    public void saveFullIncident(IncidentForm form) {

        // 1. Find related entities
        EntryArea area = entryAreaRepository.findById(form.getEntryAreaId())
                .orElseThrow();

        FriendlyAircraft friendly = friendlyAircraftRepository.findById(form.getFriendlyAircraftId())
                .orElseThrow();

        // 2. Create Incident
        Incident incident = new Incident();
        incident.setIncidentDate(form.getIncidentDate());
        incident.setEntryArea(area);
        incident.setFriendlyAircraft(friendly);

        // 3. Save incident first (to get ID)
        incident = incidentRepository.save(incident);

        // 4. Save incoming aircraft list
        for (IncomingAircraftDTO dto : form.getIncomingAircraft()) {

            AircraftType type = aircraftTypeRepository.findById(dto.getAircraftTypeId())
                    .orElseThrow();

            IncomingAircraft ia = new IncomingAircraft();
            ia.setAircraftType(type);
            ia.setQuantity(dto.getQuantity());
            ia.setIncident(incident);

            incident.getIncomingAircraft().add(ia);
        }

        // 5. Final save (cascade handles list)
        incidentRepository.save(incident);
    }

    public List<Incident> getAll() {
        return incidentRepository.findAll();
    }

    public List<Incident> getByDate(LocalDate date) {
        return incidentRepository.findByIncidentDate(date);
    }

    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }
}

