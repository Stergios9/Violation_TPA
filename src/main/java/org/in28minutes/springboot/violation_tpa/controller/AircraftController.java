package org.in28minutes.springboot.violation_tpa.controller;

import org.in28minutes.springboot.violation_tpa.entity.AFNS;
import org.in28minutes.springboot.violation_tpa.entity.Fighter;
import org.in28minutes.springboot.violation_tpa.entity.MEA;
import org.in28minutes.springboot.violation_tpa.entity.Other;
import org.in28minutes.springboot.violation_tpa.service.AircraftDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftDataService aircraftDataService;

    public AircraftController(AircraftDataService aircraftDataService) {
        this.aircraftDataService = aircraftDataService;
    }

    @GetMapping("/fighters/{country}")
    public List<Fighter> getFighters(@PathVariable String country) {
        return aircraftDataService.getFightersByCountry(country);
    }

    @GetMapping("/afns/{country}")
    public List<AFNS> getAFNS(@PathVariable String country) {
        return aircraftDataService.getAFNSByCountry(country);
    }

    @GetMapping("/mea/{country}")
    public List<MEA> getMEA(@PathVariable String country) {
        return aircraftDataService.getMEAByCountry(country);
    }

    @GetMapping("/other/{country}")
    public List<Other> getOther(@PathVariable String country) {
        return aircraftDataService.getOtherByCountry(country);
    }
}