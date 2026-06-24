package org.in28minutes.springboot.violation_tpa.controller;

import org.in28minutes.springboot.violation_tpa.dto.IncidentForm;
import org.in28minutes.springboot.violation_tpa.service.IncidentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/incident")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping("/save")
    public String saveIncident(@ModelAttribute IncidentForm form) {

        incidentService.saveFullIncident(form);

        return "redirect:/";
    }
}