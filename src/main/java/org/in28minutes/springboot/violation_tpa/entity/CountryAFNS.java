package org.in28minutes.springboot.violation_tpa.entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;

@Entity
@Table(name = "country_afns")
public class CountryAFNS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Country country;

    @ManyToOne
    private AFNS afns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public AFNS getAfns() {
        return afns;
    }

    public void setAfns(AFNS afns) {
        this.afns = afns;
    }
}
