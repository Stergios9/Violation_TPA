package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.AircraftType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AircraftTypeRepository extends JpaRepository<AircraftType, Long> {

    List<AircraftType> findByCategory(String category);

}