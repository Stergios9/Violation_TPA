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
    private final HelicopterRepository helicopterRepository;
    private final AfnsRepository afnsRepository;
    private final MeaRepository meaRepository;
    private final OtherRepository otherRepository;

    private final CountryFighterRepository countryFighterRepository;
    private final CountryAFNSRepository countryAFNSRepository;
    private final CountryHelicopterRepository countryHelicopterRepository;
    private final CountryMEARepository countryMEARepository;
    private final CountryOtherRepository countryOtherRepository;


    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            CountryRepository countryRepository,
            FighterRepository fighterRepository, HelicopterRepository helicopterRepository, AfnsRepository afnsRepository, MeaRepository meaRepository,
            CountryFighterRepository countryFighterRepository, OtherRepository otherRepository,
            RoleRepository roleRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            CountryAFNSRepository countryAFNSRepository, CountryHelicopterRepository countryHelicopterRepository, CountryMEARepository countryMEARepository, CountryOtherRepository countryOtherRepository) {
        this.countryRepository = countryRepository;
        this.fighterRepository = fighterRepository;
        this.helicopterRepository = helicopterRepository;
        this.afnsRepository = afnsRepository;
        this.meaRepository = meaRepository;
        this.countryFighterRepository = countryFighterRepository;
        this.otherRepository = otherRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.countryAFNSRepository = countryAFNSRepository;
        this.countryHelicopterRepository = countryHelicopterRepository;
        this.countryMEARepository = countryMEARepository;
        this.countryOtherRepository = countryOtherRepository;
    }

    @Override
    public void run(String... args) {

        initCountries();
        initFighters();
        initHelicopters();
        initAfns();
        initMea();
        initOther();
        initCountryFighters();
        initCountryHelicopters();
        initCountryAfns();
        initCountryMea();
        initCountryOther();
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
                new Fighter(null, "MIG-31"),

                //THESE ARE IN ΤΟΥΡΚΙΚΑ_ΜΑΧΗΤΙΚΑ ΑΛΛΑ ΟΧΙ ΣΤΑ ΜΑΧΗΤΙΚΑ. ΑΠΛΑ ΤΑ ΠΡΟΣΘΕΤΩ ΕΔΩ ΓΙΑΤΙ ΜΑΛΛΟΝ ΘΑ ΕΠΡΕΠΕ ΝΑ ΥΠΑΡΧΟΥΝ
                new Fighter(null, "EF-2000"),
                new Fighter(null, "NF-5"),
                new Fighter(null, "KAAN")
        ));
        }
    private void initHelicopters() {

        if (helicopterRepository.count() > 0) return;

        helicopterRepository.saveAll(List.of(
                new Helicopter(null, "AA-204"),
                new Helicopter(null, "AA-205"),
                new Helicopter(null, "AB-206"),
                new Helicopter(null, "AA-212"),
                new Helicopter(null, "AH-1"),
                new Helicopter(null, "AS-332"),
                new Helicopter(null, "AS-532"),
                new Helicopter(null, "CH-47"),
                new Helicopter(null, "MIL-MI-17"),
                new Helicopter(null, "OH-58"),
                new Helicopter(null, "S-70"),
                new Helicopter(null, "T-70"),
                new Helicopter(null, "T-129"),
                new Helicopter(null, "TH-300"),
                new Helicopter(null, "UH-1")
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
                new MEA(null, "MQ-9"),
                new MEA(null, "AKINCI"),
                new MEA(null, "AKSUNGUR"),
                new MEA(null, "HARPY"),
                new MEA(null, "I-GNAT"),
                new MEA(null, "GNAT-750"),
                new MEA(null, "KARAYEL"),
                new MEA(null, "CALDIRAM"),
                new MEA(null, "KIZILELMA")
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

        if (countryFighterRepository.count() > 0)
            return;

        Country turkey = countryRepository.findByName("TURKEY")
                .orElseThrow();

        countryFighterRepository.saveAll(List.of(

                new CountryFighter(
                        turkey,
                        fighterRepository.findByTypeName("F-4").orElseThrow()
                ),

                new CountryFighter(
                        turkey,
                        fighterRepository.findByTypeName("F-16").orElseThrow()
                ),

                new CountryFighter(
                        turkey,
                        fighterRepository.findByTypeName("EF-2000").orElseThrow()
                ),

                new CountryFighter(
                        turkey,
                        fighterRepository.findByTypeName("NF-5").orElseThrow()
                ),

                new CountryFighter(
                        turkey,
                        fighterRepository.findByTypeName("KAAN").orElseThrow()
                )
        ));
    }


    // =========================
    // COUNTRY ↔ helicopter MAPPING
    // =========================
    private void initCountryHelicopters() {

        if (countryHelicopterRepository.count() > 0)
            return;

        Country turkey = countryRepository.findByName("TURKEY")
                .orElseThrow();

        countryHelicopterRepository.saveAll(List.of(

                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("AA-204").orElseThrow()
                ),

                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("AA-205").orElseThrow()
                ),

                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("AB-206").orElseThrow()
                ),

                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("AA-212").orElseThrow()
                ),

                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("AH-1").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("AS-332").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("AS-532").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("CH-47").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("MIL-MI-17").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("OH-58").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("S-70").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("T-70").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("T-129").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("TH-300").orElseThrow()
                ),
                new CountryHelicopter(
                        turkey,
                        helicopterRepository.findByTypeName("UH-1").orElseThrow()
                )
        ));
    }

    // =========================
    // COUNTRY ↔ AFNS MAPPING
    // =========================
    private void initCountryAfns() {

        if (countryAFNSRepository.count() > 0) return;

        Country turkey = countryRepository.findByName("TURKEY")
                .orElseThrow();

       countryAFNSRepository.saveAll(List.of(
                new CountryAFNS(
                        turkey,
                        afnsRepository.findByTypeName("P-72").orElseThrow()
                ),

                new CountryAFNS(
                        turkey,
                        afnsRepository.findByTypeName("P-235").orElseThrow()
                )

       ));
    }
    // =========================
    // COUNTRY ↔ MEA MAPPING
    // =========================
    private void initCountryMea() {

        if (countryMEARepository.count() > 0) return;

        Country turkey = countryRepository.findByName("TURKEY")
                .orElseThrow();

        countryMEARepository.saveAll(List.of(
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("ANKA").orElseThrow()
                ),

                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("AKINCI").orElseThrow()
                ),
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("AKSUNGUR").orElseThrow()
                ),
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("BAYRAKTAR").orElseThrow()
                ),
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("HERON").orElseThrow()
                ),
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("HARPY").orElseThrow()
                ),
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("I-GNAT").orElseThrow()
                ),
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("GNAT-750").orElseThrow()
                ),
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("KARAYEL").orElseThrow()
                ),
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("CALDIRAM").orElseThrow()
                ),
                new CountryMEA(
                        turkey,
                        meaRepository.findByTypeName("KIZILELMA").orElseThrow()
                )
        ));
    }

    // =========================
    // COUNTRY ↔ Other MAPPING
    // =========================
    private void initCountryOther() {

        if (countryOtherRepository.count() > 0) return;

        Country turkey = countryRepository.findByName("TURKEY")
                .orElseThrow();

        countryOtherRepository.saveAll(List.of(
                new CountryOther(
                        turkey,
                        otherRepository.findByTypeName("A400").orElseThrow()
                ),

                new CountryOther(
                        turkey,
                        otherRepository.findByTypeName("C-130").orElseThrow()
                ),
                new CountryOther(
                        turkey,
                        otherRepository.findByTypeName("C-160").orElseThrow()
                ),
                new CountryOther(
                        turkey,
                        otherRepository.findByTypeName("CN-235").orElseThrow()
                ),
                new CountryOther(
                        turkey,
                        otherRepository.findByTypeName("T-38").orElseThrow()
                ),
                new CountryOther(
                        turkey,
                        otherRepository.findByTypeName("KC-135").orElseThrow()
                ),
                new CountryOther(
                        turkey,
                        otherRepository.findByTypeName("E-7").orElseThrow()
                ),
                new CountryOther(
                        turkey,
                        otherRepository.findByTypeName("EP-235").orElseThrow()
                ),
                new CountryOther(
                        turkey,
                        otherRepository.findByTypeName("G550").orElseThrow()
                )

        ));
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
