package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.Country;
import org.in28minutes.springboot.violation_tpa.entity.CountryOther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryOtherRepository extends JpaRepository<CountryOther, Long> {

    List<CountryOther> findByCountry(Country country);

}