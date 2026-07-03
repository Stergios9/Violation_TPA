package org.in28minutes.springboot.violation_tpa.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.in28minutes.springboot.violation_tpa.dto.IncidentFormDTO;
import org.in28minutes.springboot.violation_tpa.entity.User;
import org.in28minutes.springboot.violation_tpa.service.*;
import org.in28minutes.springboot.violation_tpa.service.ExcelService;
import org.in28minutes.springboot.violation_tpa.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    private final EntryAreaService entryAreaService;

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

    @GetMapping("/main-page")
    public String mainPage(HttpSession session, Model model) {

        String country = (String) session.getAttribute("selectedCountry");

        if (country == null) {
            return "redirect:/select-country";
        }

        model.addAttribute("country", country);

        return "main-page";
    }

    @GetMapping("/admin-main-page")
    public String adminMain(HttpSession session, Model model) {

        String country = (String) session.getAttribute("selectedCountry");

        model.addAttribute("country", country);

        return "admin-main-page";
    }

    @GetMapping("/super-main-page")
    public String superPage(HttpSession session, Model model) {

        String country = (String) session.getAttribute("selectedCountry");

        model.addAttribute("country", country);

        return "super-main-page";
    }

    @PostMapping("/incident/exportExcel")
    public void exportExcel(
            @ModelAttribute IncidentFormDTO dto,
            HttpServletResponse response) throws IOException {

        excelService.exportIncidentToExcel(dto, response);

    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }


    // Manual Authentication (not recommended for production, use Spring Security's built-in mechanisms instead)
//    @PostMapping("/loginManual")
//    public String loginManual(@RequestBody User user) {
//
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//
//        if (authentication.isAuthenticated())
//            return jwtService.generateToken(user.getUsername());
//        else return "Login Failed";
//    }


//    @GetMapping("/home")
//    public String homePage(Model model) {
//
//        List<AircraftType> allAircraft = aircraftTypeService.getAll();
//
//        Map<String, List<AircraftType>> aircraftGrouped =
//                allAircraft.stream()
//                        .collect(Collectors.groupingBy(AircraftType::getCategory));
//
//        model.addAttribute("aircraftGrouped", aircraftGrouped);
//        model.addAttribute("entryAreas", entryAreaService.getAll());
//        model.addAttribute("friendlyAircraftList", friendlyAircraftService.getAll());
//        model.addAttribute("incidentFormDTO", new IncidentFormDTO());
//
//        return "main-page";
//    }

}
