package org.in28minutes.springboot.violation_tpa.security;

import org.in28minutes.springboot.violation_tpa.entity.Country;
import org.in28minutes.springboot.violation_tpa.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService  {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country findByName(String name) {
        return countryRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }
}
