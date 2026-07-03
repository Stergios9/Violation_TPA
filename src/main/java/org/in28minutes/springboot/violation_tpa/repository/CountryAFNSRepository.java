package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.Country;
import org.in28minutes.springboot.violation_tpa.entity.CountryAFNS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryAFNSRepository extends JpaRepository<CountryAFNS, Long> {

    List<CountryAFNS> findByCountry(Country country);

}