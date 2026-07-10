package org.in28minutes.springboot.violation_tpa.repository.incident;

import org.in28minutes.springboot.violation_tpa.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

    List<Incident> findByIncidentDate(LocalDate incidentDate);

}