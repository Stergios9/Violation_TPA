package org.in28minutes.springboot.violation_tpa.repository;

import org.in28minutes.springboot.violation_tpa.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

    List<Country> findAll();

    Optional<Country> findByName(String name);

    @Override
    <S extends Country> List<S> saveAll(Iterable<S> entities);
}
