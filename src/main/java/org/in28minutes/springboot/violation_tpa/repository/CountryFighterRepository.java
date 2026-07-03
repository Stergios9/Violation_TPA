package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.Country;
import org.in28minutes.springboot.violation_tpa.entity.CountryFighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryFighterRepository extends JpaRepository<CountryFighter, Long> {

    List<CountryFighter> findByCountry(Country country);

}