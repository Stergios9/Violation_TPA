package org.in28minutes.springboot.violation_tpa.controller;

import org.in28minutes.springboot.violation_tpa.dto.IncidentFormDTO;
import org.in28minutes.springboot.violation_tpa.dto.UserDto;
import org.in28minutes.springboot.violation_tpa.entity.AircraftType;
import org.in28minutes.springboot.violation_tpa.entity.EntryArea;
import org.in28minutes.springboot.violation_tpa.entity.FriendlyAircraft;
import org.in28minutes.springboot.violation_tpa.entity.User;
import org.in28minutes.springboot.violation_tpa.service.AircraftTypeService;
import org.in28minutes.springboot.violation_tpa.service.EntryAreaService;
import org.in28minutes.springboot.violation_tpa.service.FriendlyAircraftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class LoginController {

    private final AircraftTypeService aircraftTypeService;
    private final EntryAreaService entryAreaService;
    private final FriendlyAircraftService friendlyAircraftService;

    public LoginController(AircraftTypeService aircraftTypeService,
                           EntryAreaService entryAreaService,
                           FriendlyAircraftService friendlyAircraftService) {
        this.aircraftTypeService = aircraftTypeService;
        this.entryAreaService = entryAreaService;
        this.friendlyAircraftService = friendlyAircraftService;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String homePage(Model model) {

        List<AircraftType> allAircraft = aircraftTypeService.getAll();

        Map<String, List<AircraftType>> aircraftGrouped =
                allAircraft.stream()
                        .collect(Collectors.groupingBy(AircraftType::getCategory));

        model.addAttribute("aircraftGrouped", aircraftGrouped);
        model.addAttribute("entryAreas", entryAreaService.getAll());
        model.addAttribute("friendlyAircraftList", friendlyAircraftService.getAll());
        model.addAttribute("incidentFormDTO", new IncidentFormDTO());

        return "main-page";
    }

    @GetMapping("/login")
    public String returnLoginPage() {

        return "login-page";
    }
//    List<AircraftType> allAircraft = aircraftTypeService.getAll();
//
//    Map<String, List<AircraftType>> aircraftGrouped =
//            allAircraft.stream()
//                    .collect(Collectors.groupingBy(AircraftType::getCategory));
//
//    List<EntryArea> entryAreas = entryAreaService.getAll();
//
//    List<FriendlyAircraft> friendlyAircraft = friendlyAircraftService.getAll();
//
//        model.addAttribute("aircraftGrouped", aircraftGrouped);
//        model.addAttribute("entryAreas", entryAreas);
//        model.addAttribute("friendlyAircraftList", friendlyAircraft);
//        model.addAttribute("user", new User());

}