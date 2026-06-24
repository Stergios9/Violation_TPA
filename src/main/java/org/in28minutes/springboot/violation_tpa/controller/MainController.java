package org.in28minutes.springboot.violation_tpa.controller;

import org.in28minutes.springboot.violation_tpa.entity.AircraftType;
import org.in28minutes.springboot.violation_tpa.entity.EntryArea;
import org.in28minutes.springboot.violation_tpa.entity.FriendlyAircraft;
import org.in28minutes.springboot.violation_tpa.service.AircraftTypeService;
import org.in28minutes.springboot.violation_tpa.service.EntryAreaService;
import org.in28minutes.springboot.violation_tpa.service.FriendlyAircraftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private final AircraftTypeService aircraftTypeService;
    private final EntryAreaService entryAreaService;
    private final FriendlyAircraftService friendlyAircraftService;

    public MainController(AircraftTypeService aircraftTypeService,
                          EntryAreaService entryAreaService,
                          FriendlyAircraftService friendlyAircraftService) {
        this.aircraftTypeService = aircraftTypeService;
        this.entryAreaService = entryAreaService;
        this.friendlyAircraftService = friendlyAircraftService;
    }

    @GetMapping("/")
    public String home(Model model) {

        // 1. All aircraft types
        List<AircraftType> allAircraft = aircraftTypeService.getAll();

        // 2. GROUP BY category (ΜΑΧΗΤΙΚΑ, ΑΦΝΣ κλπ)
        Map<String, List<AircraftType>> aircraftGrouped =
                allAircraft.stream()
                        .collect(Collectors.groupingBy(AircraftType::getCategory));

        // 3. Entry areas
        List<EntryArea> entryAreas = entryAreaService.getAll();

        // 4. Friendly aircraft
        List<FriendlyAircraft> friendlyAircraft = friendlyAircraftService.getAll();


        // MODEL ATTRIBUTES (sent to Thymeleaf)

        model.addAttribute("aircraftGrouped", aircraftGrouped);
        model.addAttribute("entryAreas", entryAreas);
        model.addAttribute("friendlyAircraftList", friendlyAircraft);

        return "main-page";
    }
}