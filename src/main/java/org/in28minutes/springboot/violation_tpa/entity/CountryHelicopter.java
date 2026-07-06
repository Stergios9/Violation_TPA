package org.in28minutes.springboot.violation_tpa.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "country_helicopter")
public class CountryHelicopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "helicopter_id")
    private Helicopter helicopter;

    public CountryHelicopter(Country country, Helicopter helicopter) {
        this.country = country;
        this.helicopter = helicopter;
    }

    public CountryHelicopter() {
    }

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

    public Helicopter getHelicopter() {
        return helicopter;
    }

    public void setHelicopter(Helicopter helicopter) {
        this.helicopter = helicopter;
    }
}
