package org.in28minutes.springboot.violation_tpa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate incidentDate;

    @ManyToOne
    @JoinColumn(name = "entry_area_id")
    private EntryArea entryArea;

    @ManyToOne
    @JoinColumn(name = "friendly_aircraft_id")
    private FriendlyAircraft friendlyAircraft;

    @OneToMany(mappedBy = "incident",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<IncomingAircraft> incomingAircraft = new ArrayList<>();

    public Incident() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public EntryArea getEntryArea() {
        return entryArea;
    }

    public void setEntryArea(EntryArea entryArea) {
        this.entryArea = entryArea;
    }

    public FriendlyAircraft getFriendlyAircraft() {
        return friendlyAircraft;
    }

    public void setFriendlyAircraft(FriendlyAircraft friendlyAircraft) {
        this.friendlyAircraft = friendlyAircraft;
    }

    public List<IncomingAircraft> getIncomingAircraft() {
        return incomingAircraft;
    }

    public void setIncomingAircraft(List<IncomingAircraft> incomingAircraft) {
        this.incomingAircraft = incomingAircraft;
    }
}
