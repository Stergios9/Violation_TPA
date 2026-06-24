package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.FriendlyAircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendlyAircraftRepository extends JpaRepository<FriendlyAircraft, Long> {
}