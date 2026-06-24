package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.IncomingAircraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomingAircraftRepository extends JpaRepository<IncomingAircraft, Long> {

    List<IncomingAircraft> findByIncidentId(Long incidentId);

}