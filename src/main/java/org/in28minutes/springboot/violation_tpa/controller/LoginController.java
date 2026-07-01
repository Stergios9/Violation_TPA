//package org.in28minutes.springboot.violation_tpa.controller;
//
//
//import org.in28minutes.springboot.violation_tpa.dto.IncidentFormDTO;
//import org.in28minutes.springboot.violation_tpa.dto.LoginRequest;
//import org.in28minutes.springboot.violation_tpa.entity.AircraftType;
//import org.in28minutes.springboot.violation_tpa.service.AircraftTypeService;
//import org.in28minutes.springboot.violation_tpa.service.EntryAreaService;
//import org.in28minutes.springboot.violation_tpa.service.FriendlyAircraftService;
//import org.in28minutes.springboot.violation_tpa.service.UserService;
//import org.in28minutes.springboot.violation_tpa.service.jwt.JwtService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
////  this works with Spring Security with formLogin in SecurityConfig.java, so we don't need to implement a separate login endpoint. However, if you want to provide a custom login page, you can do so by creating a controller method that returns the name of the login view.
//@Controller
//public class LoginController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JwtService jwtService;
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    private final AircraftTypeService aircraftTypeService;
//    private final EntryAreaService entryAreaService;
//    private final FriendlyAircraftService friendlyAircraftService;
//
//    public LoginController(AircraftTypeService aircraftTypeService,
//                          EntryAreaService entryAreaService,
//                          FriendlyAircraftService friendlyAircraftService) {
//        this.aircraftTypeService = aircraftTypeService;
//        this.entryAreaService = entryAreaService;
//        this.friendlyAircraftService = friendlyAircraftService;
//
//
//    }
//
//    @PostMapping("/login")
//    @ResponseBody
//    public String login(@RequestBody LoginRequest request) {
//
//        Authentication authentication =
//                authenticationManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(
//                                request.getUsername(),
//                                request.getPassword()
//                        )
//                );
//
//        if (authentication.isAuthenticated()) {
//            return jwtService.generateToken(request.getUsername());
//        }
//
//        throw new BadCredentialsException("Bad credentials");
//    }
//
//
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
//
//}
