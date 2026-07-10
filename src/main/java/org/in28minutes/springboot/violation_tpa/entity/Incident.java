package org.in28minutes.springboot.violation_tpa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private LocalDate incidentDate;


    @Column(nullable = false)
    private LocalDateTime createdAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "incident",
            cascade = CascadeType.ALL)
    private IncidentSummary summary;


    @OneToMany(mappedBy = "incident",
            cascade = CascadeType.ALL)
    private List<IncidentItem> items = new ArrayList<>();



    public void addItem(IncidentItem item){

        items.add(item);
        item.setIncident(this);

    }

    public Incident() {
    }

    public IncidentSummary getSummary() {
        return summary;
    }

    public void setSummary(IncidentSummary summary) {
        this.summary = summary;
    }

    public List<IncidentItem> getItems() {
        return items;
    }

    public void setItems(List<IncidentItem> items) {
        this.items = items;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getIncidentDate() {
        return incidentDate;
    }


    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public Country getCountry() {
        return country;
    }


    public void setCountry(Country country) {
        this.country = country;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }
}