package org.in28minutes.springboot.violation_tpa.controller;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpSession;
import org.in28minutes.springboot.violation_tpa.dto.IncidentFormDTO;
import org.in28minutes.springboot.violation_tpa.entity.*;
import org.in28minutes.springboot.violation_tpa.repository.*;
import org.in28minutes.springboot.violation_tpa.service.*;
import org.in28minutes.springboot.violation_tpa.service.ExcelService;
import org.in28minutes.springboot.violation_tpa.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CountryFighterRepository countryFighterRepository;
    @Autowired
    private CountryAFNSRepository countryAFNSRepository;
    @Autowired
    private CountryMEARepository countryMEARepository;
    @Autowired
    private CountryOtherRepository countryOtherRepository;
    @Autowired
    private CountryHelicopterRepository countryHelicopterRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private final EntryAreaService entryAreaService;
    @Autowired
    private IncidentService incidentService;

    public UserController(EntryAreaService entryAreaService) {
        this.entryAreaService = entryAreaService;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }


    // With formLogin, Spring Security will handle the login process automatically, so you don't need to implement a separate login endpoint. However, if you want to provide a custom login page, you can do so by creating a controller method that returns the name of the login view.
    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {

        model.addAttribute("cspNonce", request.getAttribute("cspNonce"));
        return "login-page";
    }

    @GetMapping("/turkey-user-page")
    public String mainPage(
            HttpSession session,
            Model model) {

        String countryName = (String) session.getAttribute("selectedCountry");

        Country country = countryRepository
                .findByName(countryName)
                .orElseThrow();
        model.addAttribute("country", country);

        fillInputFields(model, country);
        model.addAttribute("incidentFormDto", new IncidentFormDTO());

        return "turkey-user-page";
    }


    @PostMapping("/incident/save")
    public String saveIncident(
            @ModelAttribute("incidentFormDto") IncidentFormDTO dto,
            HttpSession session,
            Authentication authentication) {

        incidentService.saveIncident(dto, session, authentication);

        return "redirect:/turkey-user-page";
    }

    @GetMapping("/turkey-admin-page")
    public String adminMainPage(
            HttpSession session,
            Model model) {

        String countryName = (String) session.getAttribute("selectedCountry");

        Country country = countryRepository
                .findByName(countryName)
                .orElseThrow();
        model.addAttribute("country", country);

        fillInputFields(model, country);
        model.addAttribute("incidentForm", new IncidentFormDTO());
        return "turkey-admin-page";
    }

    @GetMapping("/turkey-superAdmin-page")
    public String superPage(HttpSession session, Model model) {

        String countryName = (String) session.getAttribute("selectedCountry");

        Country country = countryRepository
                .findByName(countryName)
                .orElseThrow();
        model.addAttribute("country", country);

        fillInputFields(model, country);

        return "turkey-superAdmin-page";
    }

//    @PostMapping("/incident/exportExcel")
//    public void exportExcel(
//            @ModelAttribute IncidentFormDTO dto,
//            HttpServletResponse response) throws IOException {
//
//        excelService.exportIncidentToExcel(dto, response);
//
//    }

//    @PostMapping("/register")
//    public User register(@RequestBody User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userService.saveUser(user);
//    }


private void fillInputFields(Model model, Country country) {

    List<Fighter> fighters =
            countryFighterRepository.findByCountry(country)
                    .stream()
                    .map(CountryFighter::getFighter)
                    .toList();

    List<Helicopter> helicopters =
            countryHelicopterRepository.findByCountry(country)
                    .stream()
                    .map(CountryHelicopter::getHelicopter)
                    .toList();

    List<AFNS> afns =
            countryAFNSRepository.findByCountry(country)
                    .stream()
                    .map(CountryAFNS::getAfns)
                    .toList();

    List<MEA> mea =
            countryMEARepository.findByCountry(country)
                    .stream()
                    .map(CountryMEA::getMea)
                    .toList();

    List<Other> other =
            countryOtherRepository.findByCountry(country)
                    .stream()
                    .map(CountryOther::getOther)
                    .toList();

    List<EntryArea> entryAreas = entryAreaService.getAll();

    model.addAttribute("fighters", fighters);
    model.addAttribute("helicopters", helicopters);
    model.addAttribute("afns", afns);
    model.addAttribute("mea", mea);
    model.addAttribute("other", other);
    model.addAttribute("entryAreas", entryAreas);
}

}
