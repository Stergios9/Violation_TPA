package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.MEA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeaRepository extends JpaRepository<MEA, Long> {
}
