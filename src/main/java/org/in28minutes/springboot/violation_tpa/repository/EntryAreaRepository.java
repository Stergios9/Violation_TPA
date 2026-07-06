package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.EntryArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntryAreaRepository extends JpaRepository<EntryArea, Long> {
}
