package org.in28minutes.springboot.violation_tpa.repository;


import org.in28minutes.springboot.violation_tpa.entity.AFNS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfnsRepository extends JpaRepository<AFNS, Long> {
    Optional<AFNS> findByTypeName(String typeName);
}
