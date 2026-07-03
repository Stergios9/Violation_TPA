package org.in28minutes.springboot.violation_tpa.service;

import org.in28minutes.springboot.violation_tpa.entity.*;
import org.in28minutes.springboot.violation_tpa.repository.EntryAreaRepository;
import org.in28minutes.springboot.violation_tpa.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final EntryAreaRepository entryAreaRepository;

    public IncidentService(IncidentRepository incidentRepository,
                           EntryAreaRepository entryAreaRepository) {
        this.incidentRepository = incidentRepository;
        this.entryAreaRepository = entryAreaRepository;

    }

//    @Transactional
//    public void saveFullIncident(IncidentFormDTO form) {
//
//        // 1. Find related entities
//        EntryArea area = entryAreaRepository.findById(form.getEntryAreaId())
//                .orElseThrow();
//
//        FriendlyAircraft friendly = friendlyAircraftRepository.findById(form.getFriendlyAircraftId())
//                .orElseThrow();
//
//        // 2. Create Incident
//        Incident incident = new Incident();
//        incident.setIncidentDate(form.getIncidentDate());
//        incident.setEntryArea(area);
//        incident.setFriendlyAircraft(friendly);
//
//        // 3. Save incident first (to get ID)
//        incident = incidentRepository.save(incident);
//
//        // 4. Save incoming aircraft list
//        for (IncomingAircraftDTO dto : form.getIncomingAircraft()) {
//
//            AircraftType type = aircraftTypeRepository.findById(dto.getAircraftTypeId())
//                    .orElseThrow();
//
//            IncomingAircraft ia = new IncomingAircraft();
//            ia.setAircraftType(type);
//            ia.setQuantity(dto.getQuantity());
//            ia.setIncident(incident);
//
//            incident.getIncomingAircraft().add(ia);
//        }
//
//        // 5. Final save (cascade handles list)
//        incidentRepository.save(incident);
//    }

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

