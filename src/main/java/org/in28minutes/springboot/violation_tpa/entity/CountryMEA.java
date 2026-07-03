package org.in28minutes.springboot.violation_tpa.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "country_mea")
public class CountryMEA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Country country;

    @ManyToOne
    private MEA mea;

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

    public MEA getMea() {
        return mea;
    }

    public void setMea(MEA mea) {
        this.mea = mea;
    }
}
