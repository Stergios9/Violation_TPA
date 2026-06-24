package org.in28minutes.springboot.violation_tpa.util;

import org.in28minutes.springboot.violation_tpa.entity.AircraftType;
import org.in28minutes.springboot.violation_tpa.entity.EntryArea;
import org.in28minutes.springboot.violation_tpa.entity.FriendlyAircraft;
import org.in28minutes.springboot.violation_tpa.service.AircraftTypeService;
import org.in28minutes.springboot.violation_tpa.service.EntryAreaService;
import org.in28minutes.springboot.violation_tpa.service.FriendlyAircraftService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AircraftTypeService aircraftTypeService;
    private final EntryAreaService entryAreaService;
    private final FriendlyAircraftService friendlyAircraftService;

    public DataInitializer(AircraftTypeService aircraftTypeService,
                           EntryAreaService entryAreaService,
                           FriendlyAircraftService friendlyAircraftService) {
        this.aircraftTypeService = aircraftTypeService;
        this.entryAreaService = entryAreaService;
        this.friendlyAircraftService = friendlyAircraftService;
    }

    @Override
    public void run(String... args) {

        initAircraftTypes();
        initEntryAreas();
        initFriendlyAircraft();
    }

    // ---------------- AIRCRAFT TYPES ----------------
    private void initAircraftTypes() {

        if (!aircraftTypeService.getAll().isEmpty()) return;

        List<AircraftType> list = List.of(

                // ΜΑΧΗΤΙΚΑ
                new AircraftType("ΜΑΧΗΤΙΚΑ", "F-16"),
                new AircraftType("ΜΑΧΗΤΙΚΑ", "F-4"),
                new AircraftType("ΜΑΧΗΤΙΚΑ", "F-35"),

                // ΑΦΝΣ
                new AircraftType("ΑΦΝΣ", "CN-235"),
                new AircraftType("ΑΦΝΣ", "ATR-72"),

                // Ε/Π
                new AircraftType("Ε/Π", "AH-64 Apache"),
                new AircraftType("Ε/Π", "UH-1"),

                // ΜΕΑ
                new AircraftType("ΜΕΑ", "Bayraktar TB2"),
                new AircraftType("ΜΕΑ", "Akinci"),

                // ΑΛΛΑ
                new AircraftType("ΑΛΛΑ", "Unknown UAV")
        );

        list.forEach(aircraftTypeService::save);
    }

    // ---------------- ENTRY AREAS ----------------
    private void initEntryAreas() {

        if (!entryAreaService.getAll().isEmpty()) return;

        List<EntryArea> areas = List.of(
                new EntryArea("Λήμνος"),
                new EntryArea("Ρόδος"),
                new EntryArea("Σάμος"),
                new EntryArea("Χίος"),
                new EntryArea("Καστελόριζο")
        );

        areas.forEach(entryAreaService::save);
    }

    // ---------------- FRIENDLY AIRCRAFT ----------------
    private void initFriendlyAircraft() {

        if (!friendlyAircraftService.getAll().isEmpty()) return;

        List<FriendlyAircraft> list = List.of(
                new FriendlyAircraft("F-16 Block 52+"),
                new FriendlyAircraft("F-16 Viper"),
                new FriendlyAircraft("Mirage 2000-5"),
                new FriendlyAircraft("Rafale")
        );

        list.forEach(friendlyAircraftService::save);
    }
}