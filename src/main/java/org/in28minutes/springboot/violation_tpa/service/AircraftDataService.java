package org.in28minutes.springboot.violation_tpa.service;

import org.in28minutes.springboot.violation_tpa.entity.*;
import org.in28minutes.springboot.violation_tpa.repository.CountryAFNSRepository;
import org.in28minutes.springboot.violation_tpa.repository.CountryFighterRepository;
import org.in28minutes.springboot.violation_tpa.repository.CountryMEARepository;
import org.in28minutes.springboot.violation_tpa.repository.CountryOtherRepository;
import org.in28minutes.springboot.violation_tpa.security.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftDataService {

    private final CountryFighterRepository countryFighterRepository;
    private final CountryAFNSRepository countryAFNSRepository;
    private final CountryMEARepository countryMEARepository;
    private final CountryOtherRepository countryOtherRepository;
    private final CountryService countryService;

    public AircraftDataService(
            CountryFighterRepository countryFighterRepository,
            CountryAFNSRepository countryAFNSRepository,
            CountryMEARepository countryMEARepository,
            CountryOtherRepository countryOtherRepository,
            CountryService countryService) {

        this.countryFighterRepository = countryFighterRepository;
        this.countryAFNSRepository = countryAFNSRepository;
        this.countryMEARepository = countryMEARepository;
        this.countryOtherRepository = countryOtherRepository;
        this.countryService = countryService;
    }

    public List<Fighter> getFightersByCountry(String countryName) {

        Country country = countryService.findByName(countryName);

        return countryFighterRepository.findByCountry(country)
                .stream()
                .map(CountryFighter::getFighter)
                .toList();
    }

    public List<AFNS> getAFNSByCountry(String countryName) {

        Country country = countryService.findByName(countryName);

        return countryAFNSRepository.findByCountry(country)
                .stream()
                .map(CountryAFNS::getAfns)
                .toList();
    }

    public List<MEA> getMEAByCountry(String countryName) {

        Country country = countryService.findByName(countryName);

        return countryMEARepository.findByCountry(country)
                .stream()
                .map(CountryMEA::getMea)
                .toList();
    }

    public List<Other> getOtherByCountry(String countryName) {

        Country country = countryService.findByName(countryName);

        return countryOtherRepository.findByCountry(country)
                .stream()
                .map(CountryOther::getOther)
                .toList();
    }
}
