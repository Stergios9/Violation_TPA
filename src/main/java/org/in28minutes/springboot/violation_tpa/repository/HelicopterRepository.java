package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.Helicopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HelicopterRepository extends JpaRepository<Helicopter, Long> {

    Optional<Helicopter> findByTypeName(String typeName);
}

