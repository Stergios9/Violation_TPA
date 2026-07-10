package org.in28minutes.springboot.violation_tpa.controller;

import jakarta.servlet.http.HttpSession;
import org.in28minutes.springboot.violation_tpa.security.CountryService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class CountryController {

    private final CountryService countryService;


    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/select-country")
    public String selectCountryPage(Model model) {

        model.addAttribute("countries", countryService.getAllCountries());

        return "select-country";
    }

    @PostMapping("/select-country")
    public String submitCountry(@RequestParam String country,
                                HttpSession session,
                                Authentication authentication) {

        session.setAttribute("selectedCountry", country);

        Collection<? extends GrantedAuthority> roles =
                authentication.getAuthorities();

        String redirect = "turkey-user-page";

        if (roles.stream().anyMatch(r -> r.getAuthority().equals("ROLE_SUPER_ADMIN"))) {
            redirect = "/turkey-superAdmin-page";
        }
        else if (roles.stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            redirect = "/turkey-admin-page";
        }

        return "redirect:" + redirect;
    }
//    private boolean hasRole(Authentication auth, String role) {
//        return auth.getAuthorities()
//                .stream()
//                .anyMatch(a -> a.getAuthority().equals(role));
//    }

}
