package org.in28minutes.springboot.violation_tpa.repository.incident;


import org.in28minutes.springboot.violation_tpa.entity.IncidentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentItemRepository extends JpaRepository<IncidentItem, Long> {
}
