package org.in28minutes.springboot.violation_tpa.repository;


import org.in28minutes.springboot.violation_tpa.entity.AFNS;
import org.in28minutes.springboot.violation_tpa.entity.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfnsRepository extends JpaRepository<AFNS, Long> {
}
