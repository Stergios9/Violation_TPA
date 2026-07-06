package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.Fighter;
import org.in28minutes.springboot.violation_tpa.entity.GreekFighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GreekFighterRepository extends JpaRepository<GreekFighter, Long> {
    Optional<GreekFighter> findByTypeName(String typeName);
}
