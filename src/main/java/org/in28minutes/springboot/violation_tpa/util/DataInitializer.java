package org.in28minutes.springboot.violation_tpa.util;

import org.in28minutes.springboot.violation_tpa.entity.*;
import org.in28minutes.springboot.violation_tpa.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final FighterRepository fighterRepository;
    private final AfnsRepository afnsRepository;
    private final MeaRepository meaRepository;
    private final CountryFighterRepository countryFighterRepository;
    private final OtherRepository otherRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CountryAFNSRepository countryAFNSRepository;

    public DataInitializer(
            CountryRepository countryRepository,
            FighterRepository fighterRepository, AfnsRepository afnsRepository, MeaRepository meaRepository,
            CountryFighterRepository countryFighterRepository, OtherRepository otherRepository,
            RoleRepository roleRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            CountryAFNSRepository countryAFNSRepository) {
        this.countryRepository = countryRepository;
        this.fighterRepository = fighterRepository;
        this.afnsRepository = afnsRepository;
        this.meaRepository = meaRepository;
        this.countryFighterRepository = countryFighterRepository;
        this.otherRepository = otherRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.countryAFNSRepository = countryAFNSRepository;
    }

    @Override
    public void run(String... args) {

        initCountries();
        initFighters();
        initAfns();
        initMea();
        initOther();
        initCountryFighters();
        initCountryAfns();
//        initCountryMea();
//        initCountryOther();
        initUsers();

        System.out.println("DataInitializer executed successfully");
    }

    // =========================
    // COUNTRIES
    // =========================
    private void initCountries() {

        if (countryRepository.count() > 0) return;

        countryRepository.saveAll(List.of(
                new Country(null, "TURKEY"),
                new Country(null, "GREECE"),
                new Country(null, "BULGARIA")
        ));
    }

    // =========================
    // FIGHTERS (catalog)
    // =========================
    private void initFighters() {

        if (fighterRepository.count() > 0) return;

        fighterRepository.saveAll(List.of(
                new Fighter(null, "A-10"),
                new Fighter(null, "F-4"),
                new Fighter(null, "F-5"),
                new Fighter(null, "F-15"),
                new Fighter(null, "F-16"),
                new Fighter(null, "F-18"),
                new Fighter(null, "F-22"),
                new Fighter(null, "F-35"),
                new Fighter(null, "M-2000"),
                new Fighter(null, "RAFALE"),
                new Fighter(null, "EFA TYFHOON"),
                new Fighter(null, "TORNADO"),
                new Fighter(null, "SU-24"),
                new Fighter(null, "SU-25"),
                new Fighter(null, "SU-27"),
                new Fighter(null, "SU-30"),
                new Fighter(null, "SU-34"),
                new Fighter(null, "SU-35"),
                new Fighter(null, "SU-57"),
                new Fighter(null, "MIG-29"),
                new Fighter(null, "MIG-31")
        ));
        }

    // =========================
    // AFNS (catalog)
    // =========================
    private void initAfns(){
        if(afnsRepository.count() > 0) return;

        afnsRepository.saveAll(List.of(
                new AFNS(null, "P-3"),
                new AFNS(null, "P-8"),
                new AFNS(null, "P-72"),
                new AFNS(null, "P-235"),
                new AFNS(null, "P-8"),
                new AFNS(null, "IL...")
        ));
    }

    // =========================
    // ΜΕΑ (catalog)
    // =========================
    private void initMea(){
        if(meaRepository.count() > 0) return;

        meaRepository.saveAll(List.of(
                new MEA(null, "ANKA"),
                new MEA(null, "BAYRAKTAR"),
                new MEA(null, "HERON"),
                new MEA(null, "MQ-9")
        ));
    }
    // =========================
    // Other (catalog)
    // =========================

    private void initOther(){
        if(otherRepository.count() > 0) return;

        otherRepository.saveAll(List.of(
                new Other(null, "A400"),
                new Other(null, "C-5"),
                new Other(null, "C-17"),
                new Other(null, "C-130"),
                new Other(null, "C-160"),
                new Other(null, "CN-235"),
                new Other(null, "T-38"),
                new Other(null, "T-45"),
                new Other(null, "M-349"),
                new Other(null, "KC-135"),
                new Other(null, "KC-45"),
                new Other(null, "KC-230 (MRTT)"),
                new Other(null, "E-550"),
                new Other(null, "E-7"),
                new Other(null, "EP-235"),
                new Other(null, "G550"),
                new Other(null, "AN-12"),
                new Other(null, "AN-26"),
                new Other(null, "AN-124"),
                new Other(null, "BE-200"),
                new Other(null, "Beriev A-50"),
                new Other(null, "IL-22PP"),
                new Other(null, "IL-38"),
                new Other(null, "IL-76"),
                new Other(null, "IL-78"),
                new Other(null, "IL-96")
        ));
    }

    // =========================
    // COUNTRY ↔ FIGHTER MAPPING
    // =========================
    private void initCountryFighters() {

        if (countryFighterRepository.count() > 0) return;

        Country turkey = countryRepository.findByName("TURKEY")
                .orElseThrow();

        List<Fighter> fighters = fighterRepository.findAll();

        List<CountryFighter> mappings = fighters.stream()
                .map(f -> {
                    CountryFighter cf = new CountryFighter();
                    cf.setCountry(turkey);
                    cf.setFighter(f);
                    return cf;
                })
                .toList();

        countryFighterRepository.saveAll(mappings);
    }

    // =========================
    // COUNTRY ↔ FIGHTER MAPPING
    // =========================
    private void initCountryAfns() {

        if (countryAFNSRepository.count() > 0) return;

        Country turkey = countryRepository.findByName("TURKEY")
                .orElseThrow();

        List<AFNS> afns = afnsRepository.findAll();

        List<CountryAFNS> mappings = afns.stream()
                .map(f -> {
                    CountryAFNS countryAfns = new CountryAFNS();
                    countryAfns.setCountry(turkey);
                    countryAfns.setAfns(f);
                    return countryAfns;
                })
                .toList();

        countryAFNSRepository.saveAll(mappings);
    }

    // =========================
    // USERS + ROLES
    // =========================
    private void initUsers() {

        Role admin = roleRepository.findByName("ADMIN")
                .orElseGet(() -> roleRepository.save(new Role(null, "ADMIN")));

        Role superAdmin = roleRepository.findByName("SUPER_ADMIN")
                .orElseGet(() -> roleRepository.save(new Role(null, "SUPER_ADMIN")));

        Role user = roleRepository.findByName("USER")
                .orElseGet(() -> roleRepository.save(new Role(null, "USER")));

        if (userRepository.findByUsername("admin").isEmpty()) {
            User u = new User();
            u.setUsername("admin");
            u.setPassword(passwordEncoder.encode("admin123"));
            u.setRole(admin);
            userRepository.save(u);
        }

        if (userRepository.findByUsername("superadmin").isEmpty()) {
            User u = new User();
            u.setUsername("superadmin");
            u.setPassword(passwordEncoder.encode("superadmin123"));
            u.setRole(superAdmin);
            userRepository.save(u);
        }

        if (userRepository.findByUsername("user").isEmpty()) {
            User u = new User();
            u.setUsername("user");
            u.setPassword(passwordEncoder.encode("user123"));
            u.setRole(user);
            userRepository.save(u);
        }
    }
}
