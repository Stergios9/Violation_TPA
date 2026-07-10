package org.in28minutes.springboot.violation_tpa.service;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.in28minutes.springboot.violation_tpa.dto.IncidentFormDTO;
import org.in28minutes.springboot.violation_tpa.dto.incident.IncidentItemDTO;
import org.in28minutes.springboot.violation_tpa.entity.*;
import org.in28minutes.springboot.violation_tpa.repository.CountryRepository;
import org.in28minutes.springboot.violation_tpa.repository.UserRepository;
import org.in28minutes.springboot.violation_tpa.repository.incident.IncidentItemRepository;
import org.in28minutes.springboot.violation_tpa.repository.incident.IncidentRepository;
import org.in28minutes.springboot.violation_tpa.repository.incident.IncidentSummaryRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService {


    private final IncidentRepository incidentRepository;
    private final IncidentSummaryRepository summaryRepository;
    private final IncidentItemRepository itemRepository;
    private final CountryRepository countryRepository;
    private final UserRepository userRepository;



    @Transactional
    public void saveIncident(
            IncidentFormDTO dto,
            HttpSession session,
            Authentication authentication) {

        String countryName =
                (String) session.getAttribute("selectedCountry");

        Country country =
                countryRepository
                        .findByName(countryName)
                        .orElseThrow();

        User user =
                userRepository
                        .findByUsername(authentication.getName())
                        .orElseThrow();

        // ======================
        // 1. CREATE INCIDENT
        // ======================

        Incident incident = new Incident();

        incident.setIncidentDate(dto.getIncidentDate());
        incident.setCreatedAt(LocalDateTime.now());
        incident.setCountry(country);
        incident.setUser(user);

        // ======================
        // 2. CREATE ITEMS
        // ======================

        for(IncidentItemDTO dtoItem : dto.getItems()) {

            IncidentItem item = new IncidentItem();

            item.setCategory(dtoItem.getCategory());

            item.setReferenceId(dtoItem.getReferenceId());

            item.setQuantity(dtoItem.getQuantity());

            item.setArmed(dtoItem.getArmed());


            incident.addItem(item);
        }

        // ======================
        // 3. CREATE SUMMARY
        // ======================

        IncidentSummary summary = new IncidentSummary();

        summary.setIncident(incident);

        summary.setFormations(dto.getSxhmatismoi());

        summary.setAircraft(dto.getAircraft());

        summary.setArmedFormations(dto.getOplaSxhmatismoi());

        summary.setArmedAircraft(dto.getOplaAircrafts());

        summary.setEngagements(dto.getEngagements());

        summary.setWest25(dto.getWestTo25());


        incident.setSummary(summary);

        // ======================
        // 4. SAVE
        // ======================

        incidentRepository.save(incident);

    }
}
